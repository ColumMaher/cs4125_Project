package com.project.CS4125.service;


import com.project.CS4125.model.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactory implements com.project.CS4125.service.UserFactory {

    @Override
    public User createUser(String name, String password) {
        return new User(name, password);
    }

    @Override
    public User createUserByID(int id) {
        return new User(id);
    }
}
