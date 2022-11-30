package com.project.CS4125.service;

import com.project.CS4125.model.Order;

import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);

    public List<Order> getOrder();
}
