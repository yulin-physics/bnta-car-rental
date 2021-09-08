package com.bnta.carrental.customer;

import com.bnta.carrental.car.CarRentalDB;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private CarRentalDB carRentalDB;

    public CustomerController(CarRentalDB carRentalPostgreDB){
        this.carRentalDB = carRentalPostgreDB;
    }

    @PostMapping
    public void addCustomer(@RequestBody String name, String email){
        carRentalDB.insertCustomer(name, email);
    }
}
