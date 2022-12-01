package com.project.CS4125.service;

import com.project.CS4125.model.Orders;
import com.project.CS4125.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServer implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Orders createOrder(Orders order){
        return orderRepository.save(order);
    }

    @Override
    public Orders findOrderByID(Orders order){
        return orderRepository.findById(order.getOrderId()).orElse(null);
    }

    @Override
    public List<Orders> getOrder(){
        return orderRepository.findAll();
    }
}
