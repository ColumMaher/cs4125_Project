package com.project.CS4125.model;

public class ActiveState extends OrderState {
    //Active State was designed to be the default state of an order.
    //When an order is made its default state must be active
    public ActiveState(Orders order) {
        super(order);
    }

    @Override
    public String returned() {
        order.changeState(new ReturnedState(order));
        return "Order Returned";

    }

    @Override
    public String paid() {
        order.changeState(new PaidState(order));
        return "Order Paid";
    }
}
