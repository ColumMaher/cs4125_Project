package com.project.CS4125.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VehicleUpdatePublisher implements Subject{
    private List<Observer> observerList = new ArrayList<>();
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
        for(Observer o: observerList) {
            o.addVehicle(v);
        }
    }
}
