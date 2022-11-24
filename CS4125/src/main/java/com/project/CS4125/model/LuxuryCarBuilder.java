package com.project.CS4125.model;

public class LuxuryCarBuilder implements Builder{
    private Car car;

    public LuxuryCarBuilder(String CarName) {
        car = new Car(CarName);
    }

    @Override
    public void buildBody() {
        car.setBodyType("Sedan");
    }

    @Override
    public void buildEngine() {
        car.setEngineSize(4.0f);
    }

    @Override
    public void buildFuel() {
        car.setFuel("Petrol");
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
