package com.project.CS4125.model;

import javax.persistence.*;

//@Entity
public interface Vehicle {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "vehicleID", nullable = false)
//

    void assemble();
    String BodyType();
    float EngineSize();
    String fuel();
    int SeatCapacity();
}
