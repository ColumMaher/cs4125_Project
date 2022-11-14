package com.project.CS4125.service;


import com.project.CS4125.model.User;

public interface UserFactory {

    User createUser(String name, String password);
}
