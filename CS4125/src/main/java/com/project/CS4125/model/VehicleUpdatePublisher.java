package com.project.CS4125.model;

import java.util.ArrayList;
import java.util.List;

public class VehicleUpdatePublisher implements Subject{
    private List<Observer> observerList;
    private boolean isRented;
    private Vehicle v;

    private String VehicleName;

    public VehicleUpdatePublisher(Vehicle v, String VehicleName){
        this.observerList = new ArrayList<>();
        this.isRented = false;
        this.v = v;
        this.VehicleName = VehicleName;
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
    public String getVehicleDetails(){
        String s = "Body Type: " + v.BodyType() + ",";
        s += " Engine Size: " + Float.toString(v.EngineSize()) + "Liter,";
        s += " Fuel Type: " + v.fuel() + ",";
        s += " Seat Capacity: " + Integer.toString(v.SeatCapacity());
        notifyUpdate(s);
        return s;
    }
    public String getVehicleName() {
        return VehicleName;
    }
}
