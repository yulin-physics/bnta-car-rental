## Car Rental CLI Project

### Table of contents
- [Introduction](#introduction)
- [Technologies](#technologies)
- [Set up](#setup)

## Introduction
This is a command line car rental and car management system.
There are two types of target users:
1. Car rental for customers, booking and returning cars are possible
2. Car management for the business, adding and removing cars are possible
   1. Adding a new car: prompts for car model and daily rental price, car model must be one from the CarsMake Enum
   2. Removing an existing car: prompts for car ID
   3. Show Available cars
   4. Show rented cars

All data are saved onto the file:
```
rentalDB.csv
```
You can add new cars, remove cars, make changes directly to the csv file instead of the using the command line interface.
The changes will be reflected in the car rental part of the CLI.

## Technologies
Project is created with:
- IntelliJ IDEA

## Setup
To start the CLI system, run `Main.java`

When prompted to enter username to access car management functions:  
`Enter Username: username`  
`Enter Password: passw00rd`