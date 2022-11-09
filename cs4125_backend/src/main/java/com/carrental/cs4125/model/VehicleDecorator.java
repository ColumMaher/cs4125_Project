package com.carrental.cs4125.model;

public abstract class VehicleDecorator implements Vehicle {
    protected Vehicle decoratedVehicle;

    public VehicleDecorator(Vehicle decoratedVehicle){
        this.decoratedVehicle = decoratedVehicle;
    }

    public void setAvailability(boolean available){
        decoratedVehicle.setAvailability(available);
    }

    public boolean getAvailability(){
        decoratedVehicle.getAvailability();
    }

    public void vehicleDetails(){
        decoratedVehicle.vehicleDetails();
    }
}
