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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class RegisterLoginController {

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
    public String loginUser(@ModelAttribute User user, HttpServletResponse response){

        User authenticatedUser = userService.authenticate(user.getName(), user.getPassword());

        String ID = String.valueOf(authenticatedUser.getUserID());
        Cookie cookie = new Cookie("userID", ID);

        response.addCookie(cookie);

        System.out.println(authenticatedUser.toString());

        return "redirect:/car-list";
    }
}
