package com.project.CS4125.service;

import com.project.CS4125.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServer implements OrderService{

    private List<Order> orderList;

    @Override
    public Order createOrder(Order order){
        orderList.add(order);
        return order;
    }

    @Override
    public List<Order> getOrder(){
        return orderList;
    }
}
