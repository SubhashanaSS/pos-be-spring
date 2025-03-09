package com.ss.springpos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ss.springpos.dto.OrderDto;

@Service
public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(int id);
    void deleteOrder(int id);
}
