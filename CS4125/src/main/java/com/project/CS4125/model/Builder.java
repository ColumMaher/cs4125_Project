package com.project.CS4125.model;

public interface Builder {
    //Builder interface for creating car object

    abstract void buildBody();
    abstract void buildEngine();
    abstract void buildFuel();
    abstract void buildSeats();
    abstract Car getCar();
}
