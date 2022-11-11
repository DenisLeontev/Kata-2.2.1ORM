package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    // добавил
       @Transactional
       User findOwner(String car_model, int car_series);

}
