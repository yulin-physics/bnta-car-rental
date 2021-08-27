package com.bnta.carrental;

import java.util.Objects;

public class Car {
    private int carID;
    private double price;
    private CarsMake make;
    private boolean rented;

    public Car(int carID, double price, CarsMake make, boolean rented) {
        this.carID = carID;
        this.price = price;
        this.make = make;
        this.rented= rented;
    }


    public Car(int carID, double price, CarsMake make) {
        this.carID = carID;
        this.price = price;
        this.make = make;
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
        return carID == car.carID && java.lang.Double.compare(car.price, price) == 0 && rented == car.rented && java.util.Objects.equals(make, car.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID, price, make, rented);
    }
}