package com.project.CS4125.service;

import com.project.CS4125.model.Car;
import com.project.CS4125.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServer implements CarService{
    //Service for Car Object
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findCarByID(Car car) {
        return carRepository.findById(car.getVehicleID()).orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
