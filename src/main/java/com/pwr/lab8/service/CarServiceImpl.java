package com.pwr.lab8.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pwr.lab8.model.Car;
import com.pwr.lab8.queries.SelectQueries;


public class CarServiceImpl implements CarService {

    private SelectQueries selectQueries = new SelectQueries();

    @Override
    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        
        ResultSet allRowsFromCar = selectQueries.getAllCarsFromDb();
        try {
            while (allRowsFromCar.next())
            {
                long id = allRowsFromCar.getLong("number");
                String number = allRowsFromCar.getString("number");
                long reservationNo  = allRowsFromCar.getLong("reservation");
                
                cars.add(new Car(id, number, reservationNo));
            }
        } finally {
            try {
                allRowsFromCar.close();
            } catch (Exception ignore) {
            }
        }
        return cars;
    }
}
