package com.project.CS4125.controller;

import com.project.CS4125.model.*;
import com.project.CS4125.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car-list")
public class CarViewController {

    @Autowired
    private CarService carService;
    @GetMapping
    public String carList(Model model){

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

        //carService.saveCar(Ferrari);
        //carService.saveCar(RRoyce);
        //carService.saveCar(VWGolf);
        //carService.saveCar(SUV);

        Location limerick = new Location("Limerick");
        Location cork = new Location("Cork");

        VehicleUpdatePublisher ferrariSubject = new VehicleUpdatePublisher(Ferrari);
        VehicleUpdatePublisher rrSubject = new VehicleUpdatePublisher(RRoyce);
        VehicleUpdatePublisher golfSubject = new VehicleUpdatePublisher(VWGolf);
        VehicleUpdatePublisher suvSubject = new VehicleUpdatePublisher(SUV);

        ferrariSubject.attach(limerick);
        rrSubject.attach(limerick);

        golfSubject.attach(cork);
        suvSubject.attach(cork);


        model.addAttribute("location1", limerick);
        model.addAttribute("vehicle1", Ferrari);
        model.addAttribute("vehicle2", RRoyce);
        model.addAttribute("location2", cork);
        model.addAttribute("vehicle3", VWGolf);
        model.addAttribute("vehicle4", SUV);

        return "car-list";
    }

}
