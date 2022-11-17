package com.project.CS4125.controller;

import com.project.CS4125.model.User;
import com.project.CS4125.service.CustomerFactory;
import com.project.CS4125.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerFactory userFactory;

    @Autowired
    private UserController controller;

    @GetMapping("/")
    public String registerForm(Model model){

        return "index";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){

        User u = userFactory.createUser(user.getName(), user.getPassword());
        userService.saveUser(user);
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user){

        User authenticatedUser = userService.authenticate(user.getName(), user.getPassword());

        if(authenticatedUser != null){

        }else{

        }

        System.out.println(authenticatedUser.toString());

        return "car-list";
    }


    @GetMapping("/car-list")
    public String carList(){
        return "index";
    }
}
