package com.bnta.carrental.car;

public interface CarRentalDB {
    void showAvailableCars();
    void showRentedCars();
    void insertCar(String price, String make);
//    void bookCar(int carID, int customerID);
    void removeCar(int carID);
    void insertCustomer(String name, String email);
}
