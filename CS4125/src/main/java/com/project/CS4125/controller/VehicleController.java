package com.project.CS4125.controller;

import com.project.CS4125.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car-list")
public class VehicleController {

    @GetMapping
    public String carList(Model model){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle VWGolf = new BasicCar();
        Vehicle Duster = new SUVDecorator(new BasicCar());


        vehicles.add(Duster);

        Location limerick= new Location("Limerick");
        Location cork = new Location("Cork");

        VehicleUpdatePublisher golfSubject = new VehicleUpdatePublisher(VWGolf, "Volkswagen Golf");
        VehicleUpdatePublisher dustersubject = new VehicleUpdatePublisher(Duster, "Dacia Duster");

        golfSubject.attach(limerick);
        dustersubject.attach(limerick);

        VehicleUpdatePublisher ferrariSubject = new VehicleUpdatePublisher(VWGolf, "Ferrari 458");
        VehicleUpdatePublisher rollsRoyceSubject = new VehicleUpdatePublisher(Duster, "Rolls Royce Ghost");

        ferrariSubject.attach(cork);
        rollsRoyceSubject.attach(cork);

        model.addAttribute("location1", limerick.getLocationName());
        model.addAttribute("vehicle1Name", golfSubject.getVehicleName());
        model.addAttribute("vehicle2Name", dustersubject.getVehicleName());
        model.addAttribute("location2", cork.getLocationName());
        model.addAttribute("vehicle3Name", ferrariSubject.getVehicleName());
        model.addAttribute("vehicle4Name", rollsRoyceSubject.getVehicleName());

        return "car-list";
    }

}
