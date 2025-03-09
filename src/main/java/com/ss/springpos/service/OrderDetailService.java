package com.ss.springpos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ss.springpos.dto.OrderDetailDto;

@Service
public interface OrderDetailService {
    OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto);
    List<OrderDetailDto> getAllOrderDetails();
    OrderDetailDto getOrderDetailById(int id);
    void deleteOrderDetail(int id);
}
