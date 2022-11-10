package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

     // CarService carService = context.getBean(CarService.class);

//      carService.add(new Car("Audi",3));
//      carService.add(new Car("Audi", 4));
//      carService.add(new Car("Audi", 5));
//      carService.add(new Car("Audi", 6));
//
//      List<Car> cars = carService.listCars();

      UserService userService = context.getBean(UserService.class);
     // userService.deleteAllUsers();

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", (new Car("Audi",3))));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", (new Car("Audi", 4))));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", (new Car("Audi", 5))));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", (new Car("Audi", 6))));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println("Найти владельцев \"Audi 5\"");
      System.out.println(userService.findOwner("Audi", 5));

      context.close();
   }
}
