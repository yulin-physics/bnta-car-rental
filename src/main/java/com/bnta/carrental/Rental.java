package com.bnta.carrental;

import com.bnta.carrental.car.Car;
import com.bnta.carrental.car.CarRentalListDB;

public class Rental {
    private CarRentalListDB carRentalFileDB;

    public Rental(CarRentalListDB carRentalFileDB){
        this.carRentalFileDB = carRentalFileDB;
    }

    public boolean showCars(){
        //the returned boolean indicates if any car available
        if (carRentalFileDB.getAvailableCars().isEmpty()){
            System.out.println("\nWe are sorry, no cars available at the moment. \nPlease come back later.");
            return false;

        } else{
            System.out.println("\nHere are our available cars, please enter car ID from the following list\n");

            for(Car car : carRentalFileDB.getAvailableCars()){
                System.out.println("Car ID:" + car.getCarID() + "    Model:"+ car.getMake() + "    Renting Price:" +  car.getPrice());
            }

            return true;
        }

    }

    public void bookCar(int carID){
        if (!carRentalFileDB.isCarAvailable(carID)){
            System.out.println("Please double check!");
            return;
        }

        for(Car car : carRentalFileDB.getAvailableCars()){
            if (car.getCarID() == carID){
                carRentalFileDB.carRented(car);
                System.out.println("\n" + car.getMake() + " with car ID " + car.getCarID() + " booked successfully." +
                        "\nIMPORTANT: Please make a note of your car ID and make your payment of " + car.getPrice() + " upon collection." +
                        "\nThank you for using our service!");
                break;
            }
        }

    }



    public void returnCar(int carID){
        if (!carRentalFileDB.isCarRented(carID)){
            System.out.println("Please double check!");
            return;
        }

        for(Car car : carRentalFileDB.getRentedCars()){
            if (car.getCarID() == carID){
            carRentalFileDB.carAvailable(car);
            System.out.println("\n" + car.getMake() + " with car ID " + car.getCarID() + " successfully returned." +
                    "\nThank you for using our service!");
            break;
        }
        }
    }
}
