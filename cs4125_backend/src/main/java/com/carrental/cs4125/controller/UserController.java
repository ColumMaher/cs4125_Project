package com.carrental.cs4125.controller;

import com.carrental.cs4125.model.User;
import com.carrental.cs4125.repository.UserRepository;
import com.carrental.cs4125.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3306")
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User newUser(@RequestBody User newUser) { return userService.saveUser(newUser); }
    /* Use Factory methods here later */
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
