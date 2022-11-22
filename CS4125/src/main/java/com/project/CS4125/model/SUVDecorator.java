package com.project.CS4125.model;

public class SUVDecorator extends VehicleDecorator{

    private String name;
    private String BodyType;
    private float EngineSize;
    private String fuel;
    private int SeatCapacity;

    private boolean isRented;

    public SUVDecorator(Vehicle v) {
        super(v);
        this.name = "Dacia Duster";
        this.BodyType = "SUV";
        this.EngineSize = 2;
        this.fuel = "Diesel";
        this.SeatCapacity = 5;
        this.isRented = false;
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
    @Override
    public void setRented(boolean rented) {
        isRented = rented;
    }
    public boolean isRented() {
        return isRented;
    }
}
