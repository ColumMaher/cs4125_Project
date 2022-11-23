package com.project.CS4125.model;

public class ReturnedState extends OrderState {

    public ReturnedState(Order order) {
        super(order);
    }

    @Override
    public String returned() {
        return "Order Returned";
    }

    @Override
    public String paid() {
        order.changeState(new PaidState(order));
        return "Order Paid";
    }
}
