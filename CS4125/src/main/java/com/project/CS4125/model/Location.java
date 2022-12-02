package com.project.CS4125.model;

import javax.persistence.Transient;
import java.util.ArrayList;

public class Location implements Observer{

    private String locationName;
    private ArrayList<Car> locationVehicles;
    public Location(String locName){
        this.locationName = locName;
        this.locationVehicles = new ArrayList<Car>();
    }
    public String getLocationName(){
        return locationName;
    }

    public void addCar(Car c){
        locationVehicles.add(c);
    }
    public void removeCar(Car c){
        locationVehicles.remove(c);
    }

    public ArrayList<Car> getLocationVehicles() {
        return locationVehicles;
    }

    @Override
    public void VehicleStatus(String status){
        System.out.println(status);
    }
}
