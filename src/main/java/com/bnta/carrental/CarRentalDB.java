package com.bnta.carrental;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalDB {
    private List<Car> cars;
    private List<Car> availableCars;
    private List<Car> rentedCars;

    public CarRentalDB() throws IOException {
        this.cars = new ArrayList();
        this.availableCars = new ArrayList();
        this.rentedCars = new ArrayList();

    }

    public void addCars(List<Car> cars){

        this.cars.addAll(cars);
        for (Car car : cars){
            if (car.isRented()){
                this.rentedCars.add(car);
            } else {
                this.availableCars.add(car);
            }
        }

    }

    public void addCar(Car car){

        this.cars.add(car);

        if (car.isRented()){
            this.rentedCars.add(car);
        } else {
            this.availableCars.add(car);
        }


    }



    public void removeCars(List<Car> cars){
        if (this.cars.containsAll(cars)){
        this.cars.removeAll(cars);
        this.availableCars.removeAll(cars);
        } else{
            System.out.println(cars+ "do not exist!");
        }
    }

    public void removeCar(Car car){
        if (this.cars.contains(car)){
            this.cars.remove(car);
            this.availableCars.remove(car);
        } else{
            System.out.println(car+ "do not exist!");
        }
    }

    public void carAvailable(Car car){
        this.rentedCars.remove(car);
        this.availableCars.add(car);
        car.setRented(false);
    }

    public void carRented(Car car){
        this.availableCars.remove(car);
        this.rentedCars.add(car);
        car.setRented(true);
    }

    public boolean isCarAvailable(int carID){
        List<Integer> carIDs = new ArrayList();
        for (Car car : availableCars){
            carIDs.add(car.getCarID());
        }

        boolean result = carIDs.contains(carID);

        return result;
    }

    public boolean isCarRented(int carID){
        List<Integer> carIDs = new ArrayList();
        for (Car car : rentedCars){
            carIDs.add(car.getCarID());
        }

        boolean result = carIDs.contains(carID);

        return result;
    }


    public void setPrices(float price){
        //sets the daily rental price for all cars


    }



    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }
}
