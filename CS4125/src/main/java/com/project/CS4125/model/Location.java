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
    public void VehicleStatus(String status){
        System.out.println(status);
    }

    /*public static void main(String[] args){
        Location loc1 = new Location("A");
        Location loc2 = new Location("B");
        Location loc3 = new Location("C");
        Vehicle v = new BasicCar();
        Vehicle Duster = new SUVDecorator(new BasicCar());

        VehicleUpdatePublisher p = new VehicleUpdatePublisher(v);
        VehicleUpdatePublisher DusterSubject = new VehicleUpdatePublisher(Duster);

        p.attach(loc1);
        DusterSubject.attach(loc1);
        p.attach(loc2);

        p.isVehicleRented();
        p.getVehicleDetails();
        p.rentVehicle();
        p.returnVehicle();

        DusterSubject.isVehicleRented();
        DusterSubject.getVehicleDetails();
        DusterSubject.rentVehicle();
        DusterSubject.returnVehicle();

        p.detach(loc1);
        p.attach(loc3);

    }*/
}
