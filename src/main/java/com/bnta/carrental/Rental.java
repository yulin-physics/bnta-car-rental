package com.bnta.carrental;

import java.util.List;

public class Rental {
    private CarRentalDB carRentalDB;

    public Rental(CarRentalDB carRentalDB){
        this.carRentalDB = carRentalDB;
    }

    public void showCars(){

        for(Car car : carRentalDB.getAvailableCars()){
            System.out.println(car.getCarID() + " "+ car.getMake() + " " +  car.getPrice());
        }
    }

    public void bookCar(int carID){
        for(Car car : carRentalDB.getAvailableCars()){
            if (car.getCarID() == carID){
                carRentalDB.carRented(car);
                car.setRented(true);
                System.out.println(car + " booked successfully!");
                break;
            }
        }

    }



    public void returnCar(int carID){

        for(Car car : carRentalDB.getRentedCars()){
            if (car.getCarID() == carID){
            carRentalDB.carAvailable(car);
            car.setRented(false);
            System.out.println(car + "successfully returned.");
            break;
        }
        }
    }
}
