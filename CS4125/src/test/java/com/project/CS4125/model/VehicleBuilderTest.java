package com.project.CS4125.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleBuilderTest {

    @Test
        //Test if isRented is being correctly set to default state.
    void isBuilt() {
        SportCarBuilder sportCarBuilder = new SportCarBuilder("Aston Martin");
        Director director = new Director(sportCarBuilder);
        Car AstonMartin = director.getCar();

        assertEquals("Coupe", AstonMartin.getBodyType());
        assertEquals(2.5f, AstonMartin.getEngineSize());
        assertEquals("Petrol", AstonMartin.getFuel());
        assertEquals(2, AstonMartin.getSeatCapacity());
    }
}