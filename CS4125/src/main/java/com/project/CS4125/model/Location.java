package com.project.CS4125.model;

import java.util.ArrayList;

public class Location implements Observer{

    private Vehicle v;
    private String locationName;
    ArrayList<Vehicle> locationVehicles;
    public Location(String locName){
        this.locationName = locName;
        this.locationVehicles = new ArrayList<Vehicle>();
    }
    public String getLocationName(){
        return locationName;
    }

    @Override
    public void VehicleStatus(String status){
        System.out.println(status);
    }
}
