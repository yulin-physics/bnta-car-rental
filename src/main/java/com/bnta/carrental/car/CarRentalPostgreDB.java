package com.bnta.carrental.car;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class CarRentalPostgreDB implements CarRentalDB{
    private JdbcTemplate jdbcTemplate;

    public CarRentalPostgreDB(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int showAvailableCars() {

        System.out.println("\nHere are our available cars, type the car ID to rent the car:");
        String sqlQuery = """
                SELECT id, price, make FROM car 
                WHERE customer_id IS NULL
                """;
        List<Map<String, Object>> cars = jdbcTemplate.queryForList(sqlQuery);

        for(Object car : cars){
            System.out.println(car);
        }

        return cars.size();
    }

    @Override
    public void showRentedCars() {
        System.out.println("\nHere are the rented cars: ");
        String sqlQuery = """
                SELECT id, price, make FROM car 
                WHERE customer_id IS NOT NULL
                """;
        List<Map<String, Object>> cars = jdbcTemplate.queryForList(sqlQuery);

        for(Object car : cars){
            System.out.println(car);
        }

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
    public void bookCar(int carID, int customerID) {
        String sqlQuery = """
                UPDATE car 
                SET customer_id = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(sqlQuery, customerID, carID);
    }

    @Override
    public void returnCar(int carID, int customerID) {
        String sqlQuery = """
                UPDATE car 
                SET customer_id = NULL
                WHERE id = ?
                """;
        jdbcTemplate.update(sqlQuery, carID);
    }

    @Override
    public void removeCar(int carID) {
        //TODO: assume customer already registered on database for now
        String sqlQuery = """
                DELETE FROM car WHERE id = ?
                """;

        int rowNum = jdbcTemplate.update(sqlQuery, carID);
    }

    @Override
    public Car createCarFromID(int carID) {
        String sqlQuery = """
                SELECT * FROM car WHERE id = ?
                """;

        Car car = jdbcTemplate.queryForObject(sqlQuery, new Object[]{carID}, new BeanPropertyRowMapper<>(Car.class));
        return  car;
    }

    @Override
    public void insertCustomer(String name, String email){
        String sqlQuery = """
                INSERT INTO customer (name, email) VALUES (?, ?)
                """;

        int rowNum = jdbcTemplate.update(sqlQuery, name, email);
    }
}
