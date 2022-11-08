package com.carrental.cs4125.service;

import com.carrental.cs4125.model.User;

public class CustomerFactory implements UserFactory{

    @Override
    public User createUser(String name, String password) {
        return new User(name, password);
    }
}
