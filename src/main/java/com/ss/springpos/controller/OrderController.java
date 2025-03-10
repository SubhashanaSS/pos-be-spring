package com.ss.springpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.springpos.dto.OrderDto;
import com.ss.springpos.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderController {
     @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(orderDto);
        return ResponseEntity.status(201).body(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable int id) {
        OrderDto orderDto = orderService.getOrderById(id);
        if (orderDto == null) {
            return ResponseEntity.status(404).body(null); // or use ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build(); // No content after deletion
    }
}
