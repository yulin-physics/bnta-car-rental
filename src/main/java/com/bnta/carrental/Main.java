package com.bnta.carrental;

import com.bnta.carrental.car.Car;
import com.bnta.carrental.car.misc.CarRentalListDB;
import com.bnta.carrental.file.CSVReader;
import com.bnta.carrental.file.CSVSaver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean restart = true;
       while(restart){
           restart = welcome();
       }

    }

    public static boolean welcome() throws IOException {
        boolean restart;

        File file = new File("src/main/java/com/bnta/carrental/rentalDB.csv");

        CarRentalListDB carRentalListDB = new CarRentalListDB();
        Rental rental = new Rental(carRentalListDB);

        carRentalListDB.addCars(CSVReader.readDB(file));

        Scanner scanner = new Scanner(System.in);


        System.out.println("\nCar Rental Management System CLI Program. " +
                "\ncopyright c Bright Network group 6." +
                "\nWelcome! Choose your options below" +
                "\n 1. Car Rental \n 2. Car Management");
        System.out.print("Enter option here (1 or 2): ");

        int answer = scanner.nextInt();

        boolean isCarRental;

        switch (answer){
            case 1:
                System.out.println("\nThank you for using our service! Would you like to " +
                        "\n 1. Book a car " +
                        "\n 2. Return a car");
                System.out.print("Enter option here (1 or 2): ");
                isCarRental = true;
                break;
            case 2:

                userLogin();

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
                    System.out.print("Enter car ID here: ");
                    answer = scanner.nextInt();
                    rental.bookCar(answer);

                    CSVSaver.saveDB(file, carRentalListDB.getCars());

                }

            } else {
                // return car
                System.out.println("\nYou have chosen car return, please find your car ID.");
                System.out.print("Enter car ID here: ");

                answer = scanner.nextInt();
                rental.returnCar(answer);

                CSVSaver.saveDB(file, carRentalListDB.getCars());
            }


        } else if (!isCarRental) {

            System.out.println("\nWelcome to car management interface, choose your option from below!" +
                    "\n 1. Add a new car" + "\n 2. Remove an existing car"
                    +"\n 3. Show available cars" + "\n 4. Show rented cars"
            );

            System.out.print("Enter option here (1, 2, 3 or 4): ");

            answer = scanner.nextInt();

            switch (answer){
                case 1:
                    System.out.println("\nYou have chosen to add a new car");
                    System.out.print("Enter car make: ");
                    //TODO: let user create new carsMake Enum from CLI
                    Scanner input1 = new Scanner(System.in);
                    String inputCarMake = input1.nextLine();


                    System.out.print("Enter daily price for renting: ");
                    Scanner input2 = new Scanner(System.in);
                    Double inputPrice = input2.nextDouble();

                    carRentalListDB.insertCar(inputPrice, inputCarMake);

                    CSVSaver.saveDB(file, carRentalListDB.getCars());

                    System.out.println(carRentalListDB.getCars().get(carRentalListDB.getCars().size() - 1) + " added to database");
                    break;
                case 2:
                    System.out.println("\nYou have chosen to remove a car from database (Please check available cars if you don't know the car ID)");
                    System.out.print("Enter the car ID: ");
                    answer = scanner.nextInt();

                    Car inputCar = carRentalListDB.createCarFromID(answer);
                    System.out.println(inputCar + " will be removed, press ENTER to continue");
                    Scanner confirm = new Scanner(System.in);
                    confirm.nextLine();

                    carRentalListDB.removeCar(answer);

                    CSVSaver.saveDB(file, carRentalListDB.getCars());

                    System.out.println(inputCar + " successfully removed");

                    break;
                case 3:
                    carRentalListDB.showAvailableCars();
                    break;
                case 4:
                    carRentalListDB.showRentedCars();
                    break;

            }



        } else{
            throw new IllegalArgumentException("Unexpected option: " + answer);
        }

        System.out.println("\nWould you like to use any other service? ");
        System.out.print("Enter here (y/n): ");
        scanner.nextLine();
        String replay = scanner.nextLine();

        if (replay.equals("y")){
            restart = true;
        } else {
            restart = false;
        }

        return restart;
    }

    public static void userLogin() {

        Scanner scan = new Scanner(System.in);

        boolean correctLogin = false;

        String enteredUsername;
        String enteredPassword;

        while(!correctLogin){
            System.out.print("Enter Username: ");
            enteredUsername = scan.nextLine();

            System.out.print("Enter Password: ");
            enteredPassword = scan.nextLine();

            if(enteredUsername.equals("username") && enteredPassword.equals("passw00rd")){
                System.out.println("You have logged in successfully!");
                correctLogin = true;
                break;
            }
            else{
                System.out.println("Your login info was incorrect, please try again");
            }
        }

        }

    }
