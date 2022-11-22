package com.project.CS4125.controller;

import com.project.CS4125.model.*;
import com.project.CS4125.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car-list")
public class VehicleController {

    @Autowired
    private UserService userService;


    @GetMapping("/car-list")
    public String carList(Model model){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle VWGolf = new BasicCar();
        VWGolf.assemble();

        Vehicle Duster = new SUVDecorator(new BasicCar());
        Duster.assemble();

        vehicles.add(Duster);

        model.addAttribute("Vehicles", vehicles);


        Location limerick= new Location("Limerick");
        Location cork = new Location("Cork");

        //VehicleUpdatePublisher limerickPublisher = new VehicleUpdatePublisher();
        //VehicleUpdatePublisher corkPublisher = new VehicleUpdatePublisher();

        //limerickPublisher.attach(limerick);
        //corkPublisher.attach(cork);



        return "index";
    }

}
