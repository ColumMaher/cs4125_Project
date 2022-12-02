package com.project.CS4125.service;

import com.project.CS4125.model.User;
import com.project.CS4125.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServer implements UserService {

    //Service class for User

    //Insert repository into service class
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User authenticate(String name, String password){
        return userRepository.findByNameAndPassword(name, password).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByID(User user) {
        return userRepository.findById(user.getUserID()).orElse(null);
    }
}
