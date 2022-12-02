package com.project.CS4125.model;


public abstract class OrderState {
    //State design pattern
    //Order is initially active when created
    //Order is returned when a customer returns a vehicle to location
    //Order is paid when its paid
    Orders order;

    public OrderState(Orders order) {
        this.order = order;
    }

    public abstract String  returned();
    public abstract String  paid();

}
