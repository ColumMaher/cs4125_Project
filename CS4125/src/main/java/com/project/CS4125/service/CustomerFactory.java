package com.project.CS4125.service;


import com.project.CS4125.model.User;

public class CustomerFactory implements com.project.CS4125.service.UserFactory {

    @Override
    public User createUser(String name, String password) {
        return new User(name, password);
    }
}
