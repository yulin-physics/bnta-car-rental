package com.bnta.carrental.car;

public interface CarRentalDB {
    int showAvailableCars();
    void showRentedCars();
    void insertCar(Double price, String make);
    void removeCar(int carID);
    void bookCar(int carID, int customerID);
    void returnCar(int carID, int customerID);
    void insertCustomer(String name, String email);
    Car createCarFromID(int carID);
}
