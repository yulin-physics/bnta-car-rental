package com.bnta.carrental.car;

import org.springframework.stereotype.Service;

@Service
public class CarRentalService {
    private CarRentalDB carRentalDB;

    public CarRentalService(CarRentalPostgreDB carRentalPostgreDB){
        this.carRentalDB = carRentalPostgreDB;
    }

    public void insertCar(Double price, String make){
        carRentalDB.insertCar(price, make);

    }

    public Car selectCar(int carID){
        return carRentalDB.createCarFromID(carID);
    }

    public void removeCar(int carID){
        carRentalDB.removeCar(carID);
    }

    public void bookCar(int carID, int customerID){
        carRentalDB.bookCar(carID, customerID);
    }

    public void returnCar(int carID, int customerID){
        carRentalDB.returnCar(carID, customerID);
    }

    public int showAvailableCars(){
        int num = carRentalDB.showAvailableCars();
        return num;
    }

    public void showRentedCars(){
        carRentalDB.showRentedCars();

    }



    //TODO: move business logic from CarRentalListDB to here
}
