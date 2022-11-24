package com.project.CS4125.model;

import javax.persistence.*;

@Entity
@Inheritance
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleID;

    boolean isRented = false;
    String BodyType;
    float EngineSize;
    String fuel;
    int SeatCapacity;

    public Long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Long vehicleID) {
        this.vehicleID = vehicleID;
    }

    abstract String assembleBody(String bodyType);
    abstract float assembleEngine(float EngineSize);

    abstract String assembleFuel(String fuel);

    abstract int assembleSeatCapacity(int SeatCapacity);

}
