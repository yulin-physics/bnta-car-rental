package com.bnta.carrental.car;

public interface CarRentalDB {
    void showAvailableCars();
    void showRentedCars();
    void addCar(String price, String make);
    void removeCar(int carID);
}
