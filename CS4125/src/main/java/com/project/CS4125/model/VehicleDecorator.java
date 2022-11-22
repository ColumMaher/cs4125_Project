package com.project.CS4125.model;

import java.util.ArrayList;

public class VehicleDecorator implements Vehicle{
   protected Vehicle vehicle;
   private boolean isRented;

   public VehicleDecorator(Vehicle v){
       this.vehicle = v;
       this.isRented = false;
   }

   @Override
   public void assemble(){
       this.vehicle.assemble();
   }

   @Override
   public String BodyType() {
        return vehicle.BodyType();
   }

   @Override
   public float EngineSize() {
        return vehicle.EngineSize();
   }

   @Override
   public String fuel() {
        return vehicle.fuel();
   }

   @Override
   public int SeatCapacity() {
        return vehicle.SeatCapacity();
   }
    @Override
    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isRented() {
        return isRented;
    }
}
