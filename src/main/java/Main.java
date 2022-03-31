import com.github.javafaker.Faker;
import entity.Car;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.CarRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Car car = new Car();
        Faker faker = new Faker();
        CarRepository carRepository = new CarRepository(sessionFactory);

        car.setBrand(faker.artist().name());
        car.setModel(faker.beer().name());
        car.setNatNumber(faker.numerify("sd213213"));

        carRepository.save(car);

        System.out.println(carRepository.findOne(3).toString());


        System.out.println(carRepository.findAll());
        System.out.println("----------------------------------------------------------");
        List<Car> cars = carRepository.findAll();
        for (Car someCar: cars
             ) {
            System.out.println(someCar.toString());

        }

    }
}
