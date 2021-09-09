package com.bnta.carrental.car;

import org.springframework.context.annotation.Bean;

import java.util.Objects;

public class Car {
    private int carID;
    private double price;
    private CarsMake make;
    private int customerID;

    public Car(int carID, double price, CarsMake make, int customerID) {
        this.carID = carID;
        this.price = price;
        this.make = make;
        this.customerID = customerID;
    }

    public Car() {

    }


    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CarsMake getMake() {
        return make;
    }

    public void setMake(CarsMake make) {
        this.make = make;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", price=" + price +
                ", make=" + make +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Car car = (Car) object;
        return carID == car.carID && java.lang.Double.compare(car.price, price) == 0  && java.util.Objects.equals(make, car.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID, price, make);
    }
}