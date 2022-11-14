package com.project.CS4125.model;

import java.util.ArrayList;

public class VehicleDecorator implements Vehicle{
   protected Vehicle vehicle;

   public VehicleDecorator(Vehicle v){
       this.vehicle = v;
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
}
