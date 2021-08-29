package com.bnta.carrental;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/bnta/carrental/rentalDB.csv");
        CSVReader csvReader = new CSVReader();

        CarRentalDB carRentalDB = new CarRentalDB();
        Rental rental = new Rental(carRentalDB);

//        List<Car> rentCars = new ArrayList();
//        Car audi = new Car(1 , 210.99, CarsMake.AUDI, true);
//        Car bmw = new Car(2,599.99,CarsMake.BMW, false);
//        Car mercedes = new Car(3, 100.99 , CarsMake.MERCEDES, false);
//        Car suzuki = new Car(4, 200.99, CarsMake.SUZUKI, false);
//
//        rentCars.add(audi);
//        rentCars.add(bmw);
//        rentCars.add(mercedes);
//        rentCars.add(suzuki);

        carRentalDB.addCars(csvReader.readDB(file));

        Scanner scanner = new Scanner(System.in);


        System.out.println("\nCar Rental Management System CLI Program\n" +
                "Welcome! Choose your options below." +
                "\n 1. car rental or \n 2. car management" +
                "\nPlease enter 1 or 2.");


        int answer = scanner.nextInt();

        boolean isCarRental;

        switch (answer){
            case 1:
                System.out.println("\nWould you like to \n 1. book a car \n 2. return a car  "+
                        "\nPlease enter 1 or 2.");
                isCarRental = true;
                break;
            case 2:
                System.out.println("car management!");
                isCarRental = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + answer);
        }

        if (isCarRental){
            answer = scanner.nextInt();

            if (answer == 1){
                //book car
                System.out.println("\nHere are our available cars" +
                        "\nPlease enter car ID from the following list");
                rental.showCars();

                answer = scanner.nextInt();
                rental.bookCar(answer);
                CSVSaver csvSaver = new CSVSaver();
                csvSaver.saveDB(file, carRentalDB.getCars());
            } else {
                // return car
                System.out.println("\nPlease enter car ID.");

                answer = scanner.nextInt();
                rental.returnCar(answer);
                CSVSaver csvSaver = new CSVSaver();
                csvSaver.saveDB(file, carRentalDB.getCars());
            }


        } else if (!isCarRental) {
            System.out.println("management options here!");
            //car management options here!

        } else{
            throw new IllegalArgumentException("Unexpected option: " + answer);
        }



    }



}
