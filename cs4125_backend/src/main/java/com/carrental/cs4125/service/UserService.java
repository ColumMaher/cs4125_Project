package com.carrental.cs4125.service;

import com.carrental.cs4125.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUsers();
}
