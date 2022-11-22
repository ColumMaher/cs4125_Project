package com.project.CS4125.model;

import java.util.ArrayList;
import java.util.List;

public class VehicleUpdatePublisher implements Subject{
    private List<Observer> observerList;
    private boolean isRented;
    private Vehicle v;

    public VehicleUpdatePublisher(Vehicle v){
        this.observerList = new ArrayList<>();
        this.isRented = false;
        this.v = v;
    }

    @Override
    public void attach(Observer o){
        observerList.add(o);
    }

    @Override
    public void detach(Observer o){
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyUpdate(String m){
        for(Observer o: observerList) {
            o.VehicleStatus(m);
        }
    }
    public void isVehicleRented(){
        String s;
        if (isRented == false){
            s = "Vehicle is Available";
        } else{
            s = "Vehicle is Not Available";
        }
        notifyUpdate(s);
    }
    public void rentVehicle(){
        v.setRented(true);
        notifyUpdate("Vehicle Rented");
    }
    public void returnVehicle(){
        v.setRented(false);
        notifyUpdate("Vehicle Returned");
    }
    public void getVehicleDetails(){
        String s = v.BodyType();
        s += Float.toString(v.EngineSize());
        s += v.fuel();
        s += Integer.toString(v.SeatCapacity());
        notifyUpdate(s);
    }
}
