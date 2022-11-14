package com.project.CS4125.model;

public class SportCarDecorator extends VehicleDecorator{

    public SportCarDecorator(Vehicle v) {
        super(v);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling sports car");
    }

    @Override
    public String BodyType() {
        return "Coupé";
    }

    @Override
    public float EngineSize() {
        return 2.5F;
    }

    @Override
    public String fuel() {
        return "Petrol";
    }

    @Override
    public int SeatCapacity() {
        return 2;
    }
}
