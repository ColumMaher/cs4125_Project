package com.project.CS4125.service;

import com.project.CS4125.model.Car;

import java.util.List;

public interface CarService {

    public Car saveCar(Car car);

    public List<Car> getAllCars();

    public Car findCarByID(Car car);
}
