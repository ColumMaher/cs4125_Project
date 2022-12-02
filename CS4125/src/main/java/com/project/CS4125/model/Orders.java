package com.project.CS4125.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderID", nullable = false)
    private int orderID;
    @Transient
    private OrderState State;
    @Transient
    private Car car;
    //This is required public to be loaded by controller into View.
    public int userID;
    private boolean paidStatus;
    private float moneyIn;
    private LocalDate orderDay;

    public Orders() {
    }
    public Orders(int userID, Car car) {
        this.State= new ActiveState(this);
    	this.userID = userID;
        this.car = car;
        this.paidStatus = false;
        this.orderDay = java.time.LocalDate.now();
    }

    public void changeState(OrderState s){
        this.State = s;
    }

    public OrderState getState() {
        return State;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setState(OrderState state) {
        State = state;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getOrderId() { return this.orderID; }
    public void setOrderId(int orderId) { this.orderID = orderId; }
    public int getUserId() { return this.userID; }
    public void setUserId(int userId) { this.userID = userId; }
    public boolean getPaidStatus() { return this.paidStatus; }
    public void setPaidStatus(boolean paidStatus) { this.paidStatus = paidStatus; }
    public float getMoneyIn() { return this.moneyIn; }
    public void setMoneyIn(float moneyIn) { this.moneyIn = moneyIn; }
    public LocalDate getOrderDay() { return this.orderDay; }
    public void setOrderDay(LocalDate orderDay) { this.orderDay = orderDay; }

}
