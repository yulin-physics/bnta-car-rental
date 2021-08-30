package com.bnta.carrental;

import com.bnta.carrental.car.Car;
import com.bnta.carrental.car.CarRentalDB;

import java.util.Scanner;

public class Rental {
    private CarRentalDB carRentalDB;

    public Rental(CarRentalDB carRentalDB){
        this.carRentalDB = carRentalDB;
    }

    public boolean showCars(){
        //the returned boolean indicates if any car available
        if (carRentalDB.getAvailableCars().isEmpty()){
            System.out.println("We are sorry, no cars available at the moment. \nPlease come back later");
            return false;

        } else{
            System.out.println("\nHere are our available cars" +
                    "\nPlease enter car ID from the following list");

            for(Car car : carRentalDB.getAvailableCars()){
                System.out.println(car.getCarID() + " "+ car.getMake() + " " +  car.getPrice());
            }

            return true;
        }

    }

    public void bookCar(int carID){
        if (!carRentalDB.isCarAvailable(carID)){
            System.out.println("Please double check!");
            return;
        }

        for(Car car : carRentalDB.getAvailableCars()){
            if (car.getCarID() == carID){
                carRentalDB.carRented(car);
                System.out.println(car + " booked successfully." +
                        "\nIMPORTANT: Please make a note of your car ID" +
                        "\nThank you for using our service!");
                break;
            }
        }

    }



    public void returnCar(int carID){
        if (!carRentalDB.isCarRented(carID)){
            System.out.println("Please double check!");
            return;
        }

        for(Car car : carRentalDB.getRentedCars()){
            if (car.getCarID() == carID){
            carRentalDB.carAvailable(car);
            System.out.println(car.getCarID() + " " + car.getMake() + " successfully returned." +
                    "\nThank you for using our service!");
            break;
        }
        }
    }
}
