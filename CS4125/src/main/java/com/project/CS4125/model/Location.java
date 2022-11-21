package com.project.CS4125.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Location implements Subject{
    Vehicle v;
    ArrayList<Observer> observerList;
    ArrayList<Vehicle> locationVehicles;
    public Location(){
        observerList = new ArrayList<Observer>();
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
    public void notifyUpdate(Vehicle v){
        for(Iterator<Observer> it =
            observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(v);
        }
    }

    public void addVehicle(Vehicle v){
        locationVehicles.add(v);
        notifyUpdate(v);
    }
}
