package com.ss.springpos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.springpos.dto.OrderDetailDto;
import com.ss.springpos.entity.Item;
import com.ss.springpos.entity.OrderDetail;
import com.ss.springpos.repository.ItemRepository;
import com.ss.springpos.repository.OrderDetailRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ItemRepository itemRepository; // Assuming you have an ItemRepository

    @Override
    public OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        orderDetail.setPrice(orderDetailDto.getPrice());

        Item item = itemRepository.findById(orderDetailDto.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));
        orderDetail.setItem(item);

        orderDetailRepository.save(orderDetail);

        // Create the OrderDetailDto to return
        orderDetailDto.setId(orderDetail.getId());
        return orderDetailDto;
    }

    @Override
    public List<OrderDetailDto> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            OrderDetailDto detailDto = new OrderDetailDto();
            detailDto.setId(orderDetail.getId());
            detailDto.setOrderId(orderDetail.getOrder().getId()); // Assuming Order has getId()
            detailDto.setItemId(orderDetail.getItem().getId()); // Assuming Item has getId()
            detailDto.setQuantity(orderDetail.getQuantity());
            detailDto.setPrice(orderDetail.getPrice());
            orderDetailDtos.add(detailDto);
        }
        return orderDetailDtos;
    }

    @Override
    public OrderDetailDto getOrderDetailById(int id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order detail not found"));

        OrderDetailDto detailDto = new OrderDetailDto();
        detailDto.setId(orderDetail.getId());
        detailDto.setOrderId(orderDetail.getOrder().getId()); // Assuming Order has getId()
        detailDto.setItemId(orderDetail.getItem().getId()); // Assuming Item has getId()
        detailDto.setQuantity(orderDetail.getQuantity());
        detailDto.setPrice(orderDetail.getPrice());
        return detailDto;
    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetailRepository.deleteById(id);
    }
}
