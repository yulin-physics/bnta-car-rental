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
