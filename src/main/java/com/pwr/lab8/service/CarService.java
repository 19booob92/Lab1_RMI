package com.pwr.lab8.service;

import java.sql.SQLException;
import java.util.List;

import com.pwr.lab8.model.Car;


public interface CarService {

    List<Car> getAllCars() throws SQLException;
}
