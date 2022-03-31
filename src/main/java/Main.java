import com.github.javafaker.Faker;
import entity.Car;
import entity.Client;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.CarRepository;
import repository.ClientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Scanner scanner = new Scanner(System.in);

        Car car = new Car();
        Client client = new Client();
        Faker faker = new Faker();
        CarRepository carRepository = new CarRepository(sessionFactory);
        ClientRepository clientRepository = new ClientRepository(sessionFactory);

//        car.setBrand(faker.artist().name());
//        car.setModel(faker.beer().name());
//        car.setNatNumber(faker.numerify("sd213213"));

//        carRepository.save(car);

        System.out.println(carRepository.findOne(3).toString());//find one
        System.out.println("----------------------------------------------------------");
        List<Car> cars = carRepository.findAll(); //find all
        for (Car someCar : cars) {
            System.out.println(someCar.toString());
        }
        System.out.println("----------------------------------------------------------");

//        changeCar(scanner, car, carRepository);
        newClientRegistration(scanner, client, clientRepository);


        scanner.close();
    }

    private static void changeCar(Scanner scanner, Car car, CarRepository carRepository) {
        System.out.println("Iveskite nr:");
        int find = Integer.valueOf(scanner.nextLine());
        car.setId(find);
        System.out.println("Iveskite naujas brand:");
        car.setBrand(scanner.nextLine());
        System.out.println("Iveskite naujas model:");
        car.setModel(scanner.nextLine());
        System.out.println("Iveskite naujas national number:");
        car.setNatNumber(scanner.nextLine());
        System.out.println("Iveskite naujas made year:");
        car.setMadeYear(LocalDate.parse(scanner.nextLine()));
        carRepository.updateCar(car);
        System.out.println(carRepository.findOne(find));
    }

    private static void newClientRegistration(Scanner scanner, Client client, ClientRepository clientRepository) {

        System.out.println("Iveskite client name");
        client.setName(scanner.nextLine());
        System.out.println("Iveskite client surname:");
        client.setSurname(scanner.nextLine());
        System.out.println("Iveskite client credit:");
        client.setCredit(Long.valueOf(scanner.nextLine()));
        System.out.println("Iveskite client phone nmbr");
        client.setPhone(scanner.nextLine());
        clientRepository.save(client);
        System.out.println(clientRepository.findOne(1));
    }
}
