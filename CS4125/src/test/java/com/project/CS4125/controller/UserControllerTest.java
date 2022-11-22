package com.project.CS4125.controller;

import com.project.CS4125.model.User;
import com.project.CS4125.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void add() {
        User testUser = new User("TestName", "TestPassword");
        assertEquals(testUser, testUser);
    }
}