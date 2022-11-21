package com.project.CS4125.model;

import javax.persistence.Basic;
import java.util.ArrayList;
import java.util.Iterator;

public class Location implements Observer{
    Vehicle v;
    String locationName;
    ArrayList<Vehicle> locationVehicles;
    public Location(String locName){
        this.locationName = locName;
        this.locationVehicles = new ArrayList<Vehicle>();
    }


    @Override
    public void addVehicle(Vehicle v){
        locationVehicles.add(v);
        System.out.println("Vehicle added to location " + locationName);
    }

    /*public static void main(String[] args){
        Location loc1 = new Location("A");
        Location loc2 = new Location("B");
        Location loc3 = new Location("C");
        Vehicle v = new BasicCar();
        VehicleUpdatePublisher p = new VehicleUpdatePublisher();

        p.attach(loc1);
        p.attach(loc2);

        p.notifyUpdate(v);

        p.detach(loc1);
        p.attach(loc3);

        System.out.println(loc1.locationVehicles.toString());
    }*/
}
