package com.project.CS4125.model;

import java.util.ArrayList;
import java.util.List;

public class VehicleUpdatePublisher implements Subject{
    private Observer observer;
    private boolean isRented;
    private Car car;

    private String CarName;

    public VehicleUpdatePublisher(Car car){
        this.isRented = false;
        this.car = car;
        this.CarName = car.getName();
    }

    @Override
    public void attach(Observer o){
        this.observer = o;
    }

    @Override
    public void detach(){
        observer = null;
    }

    @Override
    public void notifyUpdate(String m){
            observer.VehicleStatus(m);
    }
    public void isVehicleRented(){
        String s;
        if (car.isRented() == false){
            s = "Vehicle is Available";
        } else{
            s = "Vehicle is Not Available";
        }
        notifyUpdate(s);
    }
    public void rentVehicle(){
        car.setRented(true);
        notifyUpdate("Vehicle Rented");
    }
    public void returnVehicle(){
        car.setRented(false);
        notifyUpdate("Vehicle Returned");
    }
    public String getVehicleDetails(){
        String s = "Body Type: " + car.getBodyType() + ",";
        s += " Engine Size: " + Float.toString(car.getEngineSize()) + "Liter,";
        s += " Fuel Type: " + car.getFuel() + ",";
        s += " Seat Capacity: " + Integer.toString(car.getSeatCapacity());
        notifyUpdate(s);
        return s;
    }
    public String getVehicleName() {
        return car.getName();
    }
}
