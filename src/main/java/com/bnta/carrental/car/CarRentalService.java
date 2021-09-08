package com.bnta.carrental.car;

import org.springframework.stereotype.Service;

@Service
public class CarRentalService {
    private CarRentalDB carRentalDB;

    public CarRentalService(CarRentalPostgreDB carRentalPostgreDB){
        this.carRentalDB = carRentalPostgreDB;
    }

    public void insertCar(String price, String make){
        carRentalDB.insertCar(price, make);

    }

    //TODO: move business logic from CarRentalListDB to here
}
