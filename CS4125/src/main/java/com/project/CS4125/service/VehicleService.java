package com.project.CS4125.service;

import com.project.CS4125.model.User;
import com.project.CS4125.model.Vehicle;

import java.util.List;

public interface VehicleService {

    public Vehicle saveVehicle(Vehicle vehicle);

    public List<Vehicle> getAllVehicles();
}
