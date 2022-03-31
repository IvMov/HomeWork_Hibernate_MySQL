package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Car", schema = "eshopdb")
@Entity
public class Car {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "brand")
        private String brand;

        @Column(name = "model")
        private String model;

        @Column(name = "nat_number")
        private String natNumber;

        @Column(name = "made_year")
        private LocalDate madeYear;

    public Car() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNatNumber() {
        return natNumber;
    }

    public void setNatNumber(String natNumber) {
        this.natNumber = natNumber;
    }

    public LocalDate getMadeYear() {
        return madeYear;
    }

    public void setMadeYear(LocalDate madeYear) {
        this.madeYear = madeYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", natNumber='" + natNumber + '\'' +
                ", madeYear=" + madeYear +
                '}';
    }
}
