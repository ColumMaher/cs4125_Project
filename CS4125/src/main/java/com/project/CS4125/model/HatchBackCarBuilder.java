package com.project.CS4125.model;

public class HatchBackCarBuilder implements Builder{

    private Car car;

    public HatchBackCarBuilder(String CarName) {
        car = new Car(CarName);
    }

    @Override
    public void buildBody() {
        car.setBodyType("Hatch Back");
    }

    @Override
    public void buildEngine() {
        car.setEngineSize(1.2f);
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
