package com.project.CS4125.controller;

import com.project.CS4125.model.Order;
import com.project.CS4125.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    Order newOrder(@RequestBody Order newOrder){
        return orderService.createOrder(newOrder);
    }
    @PostMapping("/add")
    public String add(@RequestBody Order newOrder){
        orderService.createOrder(newOrder);
        return "Order Processed";
    }
    @GetMapping("/getOrder")
    public List<Order> getOrder(){
        return orderService.getOrder();
    }

}
