package com.project.CS4125.model;


public abstract class OrderState {

    Orders order;

    public OrderState(Orders order) {
        this.order = order;
    }

    public abstract String  returned();
    public abstract String  paid();

}
