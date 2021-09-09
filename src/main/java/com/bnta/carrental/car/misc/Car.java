package com.bnta.carrental.car.misc;

import com.bnta.carrental.car.CarsMake;

import java.util.Objects;

public class Car extends com.bnta.carrental.car.Car {
    private int carID;
    private double price;
    private CarsMake make;
    private int customerID;
    private boolean rented;

    public Car(int carID, double price, CarsMake make, boolean rented, int customerID) {
        this.carID = carID;
        this.price = price;
        this.make = make;
        this.customerID = customerID;
        this.rented = rented;
    }

    public Car(int carID, double price, CarsMake make, int customerID) {
        super(carID, price, make, customerID);
    }


    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", price=" + price +
                ", make=" + make +
                ", rented=" + rented +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Car car = (Car) object;
        return carID == car.carID && Double.compare(car.price, price) == 0 && rented == car.rented && Objects.equals(make, car.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID, price, make, rented);
    }
}