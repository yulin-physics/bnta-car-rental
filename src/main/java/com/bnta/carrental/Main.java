package com.bnta.carrental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){

        CarRentalDB carRentalDB = new CarRentalDB();
        Rental rental = new Rental(carRentalDB);

        List<Car> rentCars = new ArrayList();
        Car audi = new Car(1 , 210.99, CarsMake.AUDI, false);
        Car bmw = new Car(2,599.99,CarsMake.BMW, false);
        Car mercedes = new Car(3, 100.99 , CarsMake.MERCEDES, false);
        Car suzuki = new Car(4, 200.99, CarsMake.SUZUKI, false);

        rentCars.add(audi);
        rentCars.add(bmw);
        rentCars.add(mercedes);
        rentCars.add(suzuki);

        carRentalDB.addCars(rentCars);

        Scanner scanner = new Scanner(System.in);
        int answer1 = choice1();

        if (answer1 == 1){

            int answer2 = choice2();

            //book car
            if (answer2 == 1){
                System.out.println("Here are our available cars");
                rental.showCars();
                System.out.println("Please enter car ID from the following list");

                int answer3a = scanner.nextInt();

                rental.bookCar(answer3a);
            // return car
            } else {
                System.out.println("Please enter car ID.");
                int answer3b = scanner.nextInt();

                rental.returnCar(answer3b);
            }

        }


    }

    private static int choice1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice!" +
                "\n 1. car rental or \n 2. car management?" +
                "\nPlease enter 1 or 2.");

        int answer = scanner.nextInt();
        return answer;
    }

    private static int choice2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to \n 1.book or \n 2. return a car? "+
                "Please enter 1 or 2.");

        int answer2 = scanner.nextInt();
        return answer2;
    }
}
