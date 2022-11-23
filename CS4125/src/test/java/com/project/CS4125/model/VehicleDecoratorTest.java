package com.project.CS4125.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleDecoratorTest {

    @Test
        //Test if isRented is being correctly set to default state.
    void isRented() {
        Vehicle testVehicle;
        assertFalse(Vehicle.isRented);
    }
}