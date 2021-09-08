package com.bnta.carrental.car;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class CarRentalPostgreDB implements CarRentalDB{
    private JdbcTemplate jdbcTemplate;

    public CarRentalPostgreDB(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void showAvailableCars() {

    }

    @Override
    public void showRentedCars() {

    }

    @Override
    public void insertCar(Double price, String make) {
        String sqlQuery = """
                INSERT INTO car (price, make)
                VALUES(?, ?)
                """;

        int rowNum = jdbcTemplate.update(sqlQuery, price, make);
    }

    @Override
    public void removeCar(int carID) {

    }

    public void insertCustomer(String name, String email){
        String sqlQuery = """
                INSERT INTO customer (name, email) VALUES (?, ?)
                """;

        int rowNum = jdbcTemplate.update(sqlQuery, name, email);
    }
}
