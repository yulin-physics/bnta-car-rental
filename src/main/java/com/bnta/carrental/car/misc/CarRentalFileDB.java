package com.bnta.carrental.car.misc;

import com.bnta.carrental.car.Car;
import com.bnta.carrental.car.CarRentalDB;
import com.bnta.carrental.file.CSVReader;
import com.bnta.carrental.file.CSVSaver;

import java.io.*;
import java.util.List;


public class CarRentalFileDB implements CarRentalDB {
    private File file;

    public CarRentalFileDB(File file){
        this.file = file;
    }

    @Override
    public void showAvailableCars() {
        List<Car> cars = null;
        try {
            cars = CSVReader.readDB(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(Car car : cars) {
            if (!car.isRented()){
                System.out.println(car);
            }
        }
    }

    @Override
    public void showRentedCars() {
        List<Car> cars = null;
        try {
            cars = CSVReader.readDB(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(Car car : cars) {
            if (car.isRented()){
                System.out.println(car);
            }
        }
    }

    @Override
    public void addCar(String inputPrice, String inputCarMake) {
        try {
            String[] carProperties = {inputPrice, inputCarMake.toUpperCase()};
            CSVSaver.addCar(this.file, carProperties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCar(int carID) {
        try {
            CSVSaver.removeCar(file, carID);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
