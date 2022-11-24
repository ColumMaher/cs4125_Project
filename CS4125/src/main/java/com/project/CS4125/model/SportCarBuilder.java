package com.project.CS4125.model;

public class SportCarBuilder implements Builder{

    private Car car;

    public SportCarBuilder(String CarName) {
        car = new Car(CarName);
    }

    @Override
    public void buildBody() {
        car.setBodyType("Coupe");
    }

    @Override
    public void buildEngine() {
        car.setEngineSize(2.5f);
    }

    @Override
    public void buildFuel() {
        car.setFuel("Petrol");
    }

    @Override
    public void buildSeats() {
        car.setSeatCapacity(2);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
