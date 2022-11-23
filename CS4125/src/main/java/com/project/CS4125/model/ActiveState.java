package com.project.CS4125.model;

public class ActiveState extends OrderState {

    public ActiveState(Order order) {
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
