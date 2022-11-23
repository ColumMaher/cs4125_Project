package com.project.CS4125.model;

public class PaidState extends OrderState {

    public PaidState(Order order) {
        super(order);
    }

    @Override
    public String returned() {
        return "Order Returned";
    }

    @Override
    public String paid() {
        return "Order Paid";
    }
}
