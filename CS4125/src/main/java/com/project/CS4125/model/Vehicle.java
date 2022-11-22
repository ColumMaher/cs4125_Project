package com.project.CS4125.model;

public interface Vehicle {
    boolean isRented = false;
    void assemble();
    String BodyType();
    float EngineSize();
    String fuel();
    int SeatCapacity();
    void setRented(boolean rented);
}
