package com.project.CS4125.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderID", nullable = false)
    private int orderID;
    @Transient
    private OrderState State;
    @Transient
    private Vehicle v;
    private int userId;
    private int paidStatus;
    private float moneyIn;
    private Date orderDay;
    
    public Orders() {
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



    public int getOrderId() { return this.orderID; }
    public void setOrderId(int orderId) { this.orderID = orderId; }
    public int getUserId() { return this.userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getPaidStatus() { return this.paidStatus; }
    public void setPaidStatus(int paidStatus) { this.paidStatus = paidStatus; }
    public float getMoneyIn() { return this.moneyIn; }
    public void setMoneyIn(float moneyIn) { this.moneyIn = moneyIn; }
    public Date getOrderDay() { return this.orderDay; }
    public void setOrderDay(Date orderDay) { this.orderDay = orderDay; }

}
