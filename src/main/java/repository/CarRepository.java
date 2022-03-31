package repository;

import entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private SessionFactory sessionFactory;

    public CarRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Car car) {
        Session session = sessionFactory.openSession();
        session.save(car);
        session.close();
    }

    public Car findOne(int id) {
        Session session = sessionFactory.openSession();
        Car car = session.find(Car.class, id);
        session.close();
        return car;
    }

    public List<Car> findAll() {
        Session session = sessionFactory.openSession();
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            if ((session.find(Car.class, i) != null)) {
                cars.add(session.find(Car.class, i));
            } else {
                break;
            }

        }

        return cars;
    }

}
