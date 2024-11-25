package com.task.Order.Processing.system.controller;

import com.task.Order.Processing.system.model.Order;
import com.task.Order.Processing.system.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@Valid @RequestBody Order order) {
        orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully.");
    }

    @GetMapping("/processed")
    public List<Order> getProcessedOrders() {
        return orderService.getProcessedOrders();
    }

}

