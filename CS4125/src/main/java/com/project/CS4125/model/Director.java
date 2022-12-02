package com.project.CS4125.model;

public class Director {
    //Director class
    //Controls builder instances and tells builders when to construct objects
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
