package com.project.CS4125.model;

public abstract class OrderState {

    Order order;

    public OrderState(Order order) {
        this.order = order;
    }

    public abstract String  returned();
    public abstract String  paid();

}
