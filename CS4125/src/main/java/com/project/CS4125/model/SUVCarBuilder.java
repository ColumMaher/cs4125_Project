package com.project.CS4125.model;

public class SUVCarBuilder implements Builder{
    private Car car;

    public SUVCarBuilder(String CarName) {
        car = new Car(CarName);
    }

    @Override
    public void buildBody() {
        car.setBodyType("SUV");
    }

    @Override
    public void buildEngine() {
        car.setEngineSize(2.0f);
    }

    @Override
    public void buildFuel() {
        car.setFuel("Diesel");
    }

    @Override
    public void buildSeats() {
        car.setSeatCapacity(5);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
