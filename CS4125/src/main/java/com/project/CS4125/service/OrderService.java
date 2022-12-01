package com.project.CS4125.service;

import com.project.CS4125.model.Orders;

import java.util.List;

public interface OrderService {
    public Orders createOrder(Orders order);

    public List<Orders> getOrder();

    public Orders findOrderByID(Orders order);
}
