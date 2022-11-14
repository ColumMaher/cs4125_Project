package com.project.CS4125.controller;

import com.project.CS4125.model.User;
import com.project.CS4125.repository.UserRepository;
import com.project.CS4125.service.CustomerFactory;
import com.project.CS4125.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3306")
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    private CustomerFactory userFactory;

    @GetMapping("/")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/userRegister")
    public String registerUser(@ModelAttribute("user") User user){
        user = userFactory.createUser(user.getName(), user.getPassword());
        userService.saveUser(user);
        return "home";
    }

    @PostMapping
    User newUser(@RequestBody User newUser) { return userService.saveUser(newUser); }
    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "User is added";
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
