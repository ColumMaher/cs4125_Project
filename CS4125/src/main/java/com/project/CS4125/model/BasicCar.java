package com.project.CS4125.model;

public class BasicCar implements Vehicle{

    private String name;
    private String BodyType;
    private float EngineSize;
    private String fuel;
    private int SeatCapacity;

    private boolean isRented;
    public BasicCar(){
        this.name = "Golf";
        this.BodyType = "Hatch Back";
        this.EngineSize = (float) 1.2;
        this.fuel = "Petrol";
        this.SeatCapacity = 5;
        this.isRented = false;
    }
   @Override
    public void assemble(){
       System.out.println("Basic Car");
   }

    @Override
    public String BodyType() {
        return "Hatch Back";
    }

    @Override
    public float EngineSize() {
        return (float) 1.2;
    }

    @Override
    public String fuel() {
        return "Petrol";
    }

    @Override
    public int SeatCapacity() {
        return 5;
    }

    public boolean isRented() {
        return isRented;
    }
    @Override
    public void setRented(boolean rented) {
        isRented = rented;
    }
}
