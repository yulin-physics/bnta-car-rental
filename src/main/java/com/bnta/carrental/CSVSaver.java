package com.bnta.carrental;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVSaver {

    public void saveDB(File file, List<Car> cars) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println( "Car ID"+ ", " + "Price" + ", " + "Make" + ", " + "Rented");

        for (Car car : cars) {
            printWriter.println(car.getCarID() + ", " + car.getPrice() + ", " + car.getMake() + ", " + car.isRented());
        }

        printWriter.flush();
        printWriter.close();

    }
}
