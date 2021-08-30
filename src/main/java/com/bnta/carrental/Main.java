package com.bnta.carrental;

import com.bnta.carrental.car.Car;
import com.bnta.carrental.car.CarRentalDB;
import com.bnta.carrental.car.CarsMake;
import com.bnta.carrental.file.CSVReader;
import com.bnta.carrental.file.CSVSaver;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/com/bnta/carrental/rentalDB.csv");
        CSVReader csvReader = new CSVReader();
        CSVSaver csvSaver = new CSVSaver();

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

                boolean isCarAvailable = rental.showCars();
                if (isCarAvailable) {
                    answer = scanner.nextInt();
                    rental.bookCar(answer);

                    csvSaver.saveDB(file, carRentalDB.getCars());
                }

            } else {
                // return car
                System.out.println("\nPlease enter car ID.");

                answer = scanner.nextInt();
                rental.returnCar(answer);

                csvSaver.saveDB(file, carRentalDB.getCars());
            }


        } else if (!isCarRental) {
            System.out.println("Would you like to" + "\n1. Add a new car" + "\n2. Remove an existing car"
                    +"\n3. Show available cars" + "\n4. Show rented cars"
            );

            answer = scanner.nextInt();

            switch (answer){
                case 1:
                    System.out.println("Please enter car make");
                    Scanner input1 = new Scanner(System.in);
                    String inputCarMake = input1.nextLine();
                    //CarsMake is an Enum, converting String carMake to type Enum
                    CarsMake carMake = CarsMake.valueOf(inputCarMake.toUpperCase());
                    System.out.println("Please enter daily price for renting");
                    Scanner input2 = new Scanner(System.in);
                    String inputPrice = input2.nextLine();
                    //Converting price from integer to a double
                    Double price = Double.parseDouble(inputPrice);
                    int carID = carRentalDB.getLastCarID() + 1;

                    Car car = new Car(carID, price, carMake, false);
                    carRentalDB.addCar(car);

                    csvSaver.saveDB(file, carRentalDB.getCars());

                    System.out.println(car + " added to database");
                    break;
                case 2:
                    System.out.println("Enter the car ID below");
                    answer = scanner.nextInt();

                    Car inputCar = carRentalDB.createCarFromID(answer);
                    System.out.println(inputCar + "will be removed");

                    carRentalDB.removeCar(answer);

                    csvSaver.saveDB(file, carRentalDB.getCars());

                    break;
                case 3:
                    carRentalDB.showAvailableCars();
                    break;
                case 4:
                    carRentalDB.showRentedCars();
                    break;

            }



        } else{
            throw new IllegalArgumentException("Unexpected option: " + answer);
        }



    }

    public static void passwordExample() {
        Console console = System.console();

        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        console.printf("Password entered was: %s%n", new String(passwordArray));
    }



    }
