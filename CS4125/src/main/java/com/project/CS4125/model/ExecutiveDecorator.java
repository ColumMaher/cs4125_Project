package com.project.CS4125.model;

public class ExecutiveDecorator extends VehicleDecorator{

    private boolean isRented;
    public ExecutiveDecorator(Vehicle v) {
        super(v);
        this.isRented = false;
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
    @Override
    public void setRented(boolean rented) {
        isRented = rented;
    }
    public boolean isRented() {
        return isRented;
    }
}
