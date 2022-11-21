package com.project.CS4125.controller;

import com.project.CS4125.model.BasicCar;
import com.project.CS4125.model.SUVDecorator;
import com.project.CS4125.model.Vehicle;
import com.project.CS4125.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car-list")
public class VehicleController {

    @Autowired
    private UserService userService;


    @GetMapping("/car-list")
    public String carList(){

        Vehicle VWGolf = new BasicCar();
        VWGolf.assemble();

        Vehicle Duster = new SUVDecorator(new BasicCar());
        Duster.assemble();

        return "index";
    }

}
