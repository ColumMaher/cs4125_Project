package com.project.CS4125.controller;

import com.project.CS4125.model.Orders;
import com.project.CS4125.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Rest controller for order
@RestController
@CrossOrigin("http://localhost:3306")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    Orders newOrder(@RequestBody Orders newOrder){
        return orderService.createOrder(newOrder);
    }
    @PostMapping("/add")
    public String add(@RequestBody Orders newOrder){
        orderService.createOrder(newOrder);
        return "Order Processed";
    }
    @GetMapping("/getOrder")
    public List<Orders> getOrder(){
        return orderService.getOrder();
    }

}
