package com.bnta.carrental.car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CarRentalListDB implements CarRentalDB {
    private List<Car> cars;
    private List<Car> availableCars;
    private List<Car> rentedCars;

    public CarRentalListDB() throws IOException {
        this.cars = new ArrayList();
        this.availableCars = new ArrayList();
        this.rentedCars = new ArrayList();

    }

    @Override
    public void showAvailableCars(){

        if (availableCars.isEmpty()){
            System.out.println("\nNo cars available at the moment, please check rented cars");

        } else{
            System.out.println("\nHere are the available cars" );
            for (Car car : availableCars){
                System.out.println(car);
            }

        }
    }

    @Override
    public void showRentedCars(){

        if (rentedCars.isEmpty()){
            System.out.println("No cars rented");

        } else{
            System.out.println("\nHere are the rented cars" );

            for (Car car : rentedCars){
                System.out.println(car);
            }
        }

    }

    @Override
    public void insertCar(String inputPrice, String inputCarMake){

        Double price = Double.parseDouble(inputPrice);
        CarsMake carMake = CarsMake.valueOf(inputCarMake.toUpperCase());
        int carID = getLastCarID() + 1;

        Car car = new Car(carID, price, carMake, false);

        this.cars.add(car);
        if (car.isRented()){
            this.rentedCars.add(car);
        } else {
            this.availableCars.add(car);
        }

    }

    @Override
    public void removeCar(int carID){
        Car car = createCarFromID(carID);
        if (this.cars.contains(car)){
            this.cars.remove(car);
            this.availableCars.remove(car);
        } else{
            System.out.println(car+ "do not exist!");
        }

    }

    @Override
    public void insertCustomer(String name, String email) {

    }

    public int getLastCarID(){
        Car lastCar = cars.get(cars.size()-1);
        return lastCar.getCarID();
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



    public void removeCars(List<Car> cars){
        if (this.cars.containsAll(cars)){
            this.cars.removeAll(cars);
            this.availableCars.removeAll(cars);
        } else{
            System.out.println(cars+ "do not exist!");
        }
    }


    public Car createCarFromID(int carID){
        Car currentCar = null;
        for (Car car: cars){
            if (car.getCarID() == carID) {
                currentCar = car;
                break;
            }
        }
        return currentCar;
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
        for (Car car : availableCars) {
            car.setPrice(price);
        }
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

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setAvailableCars(List<Car> availableCars) {
        this.availableCars = availableCars;
    }

    public void setRentedCars(List<Car> rentedCars) {
        this.rentedCars = rentedCars;
    }

    @Override
    public String toString() {
        return "CarRentalDB{" +
                "cars=" + cars +
                ", availableCars=" + availableCars +
                ", rentedCars=" + rentedCars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRentalListDB that = (CarRentalListDB) o;
        return Objects.equals(cars, that.cars) && Objects.equals(availableCars, that.availableCars) && Objects.equals(rentedCars, that.rentedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, availableCars, rentedCars);
    }
}
