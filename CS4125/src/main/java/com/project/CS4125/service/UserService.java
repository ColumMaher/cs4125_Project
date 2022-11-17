package com.project.CS4125.service;

import com.project.CS4125.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public User authenticate(String name, String password);

    public List<User> getAllUsers();
}
