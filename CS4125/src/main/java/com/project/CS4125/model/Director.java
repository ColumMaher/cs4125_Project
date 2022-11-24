package com.project.CS4125.model;

public class Director {
    private Builder carBuilder;

    public Director(Builder carBuilder) {
        this.carBuilder = carBuilder;
    }
    public void reset(Builder carBuilder){
        this.carBuilder = carBuilder;
    }
    public void buildCar(){
        carBuilder.buildBody();
        carBuilder.buildEngine();
        carBuilder.buildFuel();
        carBuilder.buildSeats();
    }
    public Car getCar(){
        buildCar();
        return carBuilder.getCar();
    }
}
