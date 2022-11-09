package com.carrental.cs4125.model;

public class EngineVehicleDecorator extends VehicleDecorator{
    public EngineVehicleDecorator(Vehicle decoratedVehicle){
        super(decoratedVehicle);
    }

    @Override
    public void vehicleDetails(){
        decoratedVehicle.vehicleDetails();
        setEngineType(decoratedVehicle);
    }

    private void setEngineType(Vehicle decoratedVehicle){
        System.out.println("2 Litre Engine");
    }
}