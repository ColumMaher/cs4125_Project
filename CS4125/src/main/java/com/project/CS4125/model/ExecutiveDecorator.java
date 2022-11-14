package com.project.CS4125.model;

public class ExecutiveDecorator extends VehicleDecorator{

    public ExecutiveDecorator(Vehicle v) {
        super(v);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling Executive Car");
    }

    @Override
    public String BodyType() {
        return "Sedan";
    }

    @Override
    public float EngineSize() {
        return (float) 1.8;
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
