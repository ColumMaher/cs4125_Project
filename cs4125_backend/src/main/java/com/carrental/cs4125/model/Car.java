package com.carrental.cs4125.model;

public class Car implements Vehicle {

    private boolean available;
    private String model;
    private String location;
    private int carID;

    public Car(){

    }
    @Override
    public void setAvailability(boolean available){
        /*if(!available){
            System.out.println("Car is not available!")
        } else {
            System.out.println("Car is available!")
        }*/
    }
    @Override
    public boolean getAvailability(){
        boolean available = this.available;
        return available;
    }

    public void vehicleDetails(){
        System.out.println("Vehicle: Car");
    }
}