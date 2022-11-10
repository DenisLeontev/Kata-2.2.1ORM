package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User owner;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return model + ' ' + series;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Car car = (Car) o;
//
//        if (model != null ? !model.equals(car.model) : car.model != null) return false;
//        return series != null ? series.equals(car.series) : car.series == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = model != null ? model.hashCode() : 0;
//        result = 31 * result + (series != null ? series.р : 0);
//        return result;
//    }
}
