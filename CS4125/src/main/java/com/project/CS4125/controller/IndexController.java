package com.project.CS4125.controller;


import com.project.CS4125.model.User;
import com.project.CS4125.service.CustomerFactory;
import com.project.CS4125.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerFactory userFactory;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){

        User u = userFactory.createUser(user.getName(), user.getPassword());
        userService.saveUser(u);
        return "login";

    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user){

        User authenticatedUser = userService.authenticate(user.getName(), user.getPassword());
        System.out.println(authenticatedUser.toString());

        return "car-list";
    }
}
