package com.project.CS4125.controller;

import com.project.CS4125.model.*;
import com.project.CS4125.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car-list")
public class CarViewController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String carList(Model model) {

        SportCarBuilder sportCarBuilder = new SportCarBuilder("Ferrari 418");
        LuxuryCarBuilder luxuryCarBuilder = new LuxuryCarBuilder("Rolls Royce Ghost");
        HatchBackCarBuilder hatchBackCarBuilder = new HatchBackCarBuilder("Golf TSI");
        SUVCarBuilder suvCarBuilder = new SUVCarBuilder("Dacia Duster");

        Director director = new Director(sportCarBuilder);
        Car Ferrari = director.getCar();

        director.reset(luxuryCarBuilder);
        Car RRoyce = director.getCar();

        director.reset(hatchBackCarBuilder);
        Car VWGolf = director.getCar();

        director.reset(suvCarBuilder);
        Car SUV = director.getCar();

        if (carService.getAllCars() == null) {
            carService.saveCar(Ferrari);
            carService.saveCar(RRoyce);
            carService.saveCar(VWGolf);
            carService.saveCar(SUV);
        }

        Location limerick = new Location("Limerick");
        limerick.addCar(Ferrari);
        limerick.addCar(RRoyce);

        Location cork = new Location("Cork");
        cork.addCar(VWGolf);
        cork.addCar(SUV);

        //Drop down/table lists per location
        ArrayList<Car> location1cars = new ArrayList<>();
        ArrayList<Car> location2cars = new ArrayList<>();

        ArrayList<Car> cars = (ArrayList<Car>) carService.getAllCars();

        for (int i = 0; i < cars.size() / 2; i++) {
            location1cars.add(cars.get(i));
        }
        for (int i = cars.size() / 2; i < cars.size(); i++) {
            location2cars.add(cars.get(i));
        }

        VehicleUpdatePublisher ferrariSubject = new VehicleUpdatePublisher(Ferrari);
        VehicleUpdatePublisher rrSubject = new VehicleUpdatePublisher(RRoyce);
        VehicleUpdatePublisher golfSubject = new VehicleUpdatePublisher(VWGolf);
        VehicleUpdatePublisher suvSubject = new VehicleUpdatePublisher(SUV);

        ferrariSubject.attach(limerick);
        rrSubject.attach(limerick);

        golfSubject.attach(cork);
        suvSubject.attach(cork);

        model.addAttribute("location1", limerick);
        model.addAttribute("location2", cork);
        model.addAttribute("location1vehicles", location1cars);
        model.addAttribute("location2vehicles", location2cars);


        return "car-list";
    }

    @PostMapping("/car-list/order")
    public String orderVehicle(/*@RequestParam(value = "SelectVehicle") Car vehicle, @ModelAttribute Car car*/) {

        //System.out.println(car.getVehicleID());
        //System.out.println(vehicle.getVehicleID());
        System.out.println("Test");

        return "order";
    }
    @GetMapping("/order")
    public String order(){return "order";}
}
