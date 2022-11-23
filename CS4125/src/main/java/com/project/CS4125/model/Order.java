package com.project.CS4125.model;

import java.util.Date;

public class Order {

    private OrderState State;
    private int orderId;
    private Vehicle v;
    private int userId;
    private int paidStatus;
    private float moneyIn;
    private Date orderDay;
    
    public Order() {
        this.State= new ActiveState(this);
    	
    }

    public void changeState(OrderState s){
        this.State = s;
    }

    public OrderState getState() {
        return State;
    }

    public void getOrderDetails(){

    }



    public int getOrderId() { return this.orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public int getUserId() { return this.userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getPaidStatus() { return this.paidStatus; }
    public void setPaidStatus(int paidStatus) { this.paidStatus = paidStatus; }
    public float getMoneyIn() { return this.moneyIn; }
    public void setMoneyIn(float moneyIn) { this.moneyIn = moneyIn; }
    public Date getOrderDay() { return this.orderDay; }
    public void setOrderDay(Date orderDay) { this.orderDay = orderDay; }

}
