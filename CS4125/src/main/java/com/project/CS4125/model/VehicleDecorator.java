package com.project.CS4125.model;

import java.util.ArrayList;

public class VehicleDecorator extends Vehicle {
   protected Vehicle vehicle;
   private boolean isRented;

   public VehicleDecorator(Vehicle v){
       this.vehicle = v;
       this.isRented = false;
   }

    @Override
    String assembleBody(String BodyType) {
        return vehicle.assembleBody(BodyType);
    }

    @Override
    float assembleEngine(float EngineSize) {
        return vehicle.assembleEngine(EngineSize);
    }

    @Override
    String assembleFuel(String fuel) {
        return vehicle.assembleFuel(fuel);
    }

    @Override
    int assembleSeatCapacity(int SeatCapacity) {
        return vehicle.assembleSeatCapacity(SeatCapacity);
    }
}
