package com.carrental.cs4125.service;

import com.carrental.cs4125.model.User;

public interface UserFactory {

    User createUser(String name, String password);
}
