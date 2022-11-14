package com.project.CS4125.model;

public class BasicCar implements Vehicle{

   @Override
    public void assemble(){
       System.out.println("Basic Car");
   }

    @Override
    public String BodyType() {
        return "Hatch Back";
    }

    @Override
    public float EngineSize() {
        return (float) 1.2;
    }

    @Override
    public String fuel() {
        return "Petrol";
    }

    @Override
    public int SeatCapacity() {
        return 5;
    }
}
