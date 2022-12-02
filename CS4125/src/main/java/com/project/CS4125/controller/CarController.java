package com.project.CS4125.controller;

import com.project.CS4125.model.Car;
import com.project.CS4125.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3306")
@RequestMapping("/Car")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping
    Car newCar(@RequestBody Car newCar) { return carService.saveCar(newCar); }
    @PostMapping("/add")
    public String add(@RequestBody Car newCar){
        carService.saveCar(newCar);
        return "Car is added";
    }
    @GetMapping("/getAllCars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
}