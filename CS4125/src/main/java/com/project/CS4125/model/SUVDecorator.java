package com.project.CS4125.model;

public class SUVDecorator extends VehicleDecorator{

    public SUVDecorator(Vehicle v) {
        super(v);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling SUV");
    }

    @Override
    public String BodyType() {
        return "SUV";
    }

    @Override
    public float EngineSize() {
        return 2;
    }

    @Override
    public String fuel() {
        return "Diesel";
    }

    @Override
    public int SeatCapacity() {
        return 5;
    }
}
