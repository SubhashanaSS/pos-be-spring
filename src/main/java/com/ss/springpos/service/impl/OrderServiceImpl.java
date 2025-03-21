package com.ss.springpos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.springpos.dto.OrderDetailDto;
import com.ss.springpos.dto.OrderDto;
import com.ss.springpos.entity.OrderDetail;
import com.ss.springpos.repository.ItemRepository;
import com.ss.springpos.repository.OrderDetailRepository;
import com.ss.springpos.repository.OrderRepository;
import com.ss.springpos.service.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderDate(orderDto.getOrderDate());
        order.setTotalAmount(orderDto.getTotalAmount());

        User user = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        order.setUser(user);

        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDto detailDto : orderDto.getOrderDetails()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setQuantity(detailDto.getQuantity());
            orderDetail.setPrice(detailDto.getPrice());

            // Set the item and check if it exists
            orderDetail.setItem(itemRepository.findById(detailDto.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found")));
            orderDetail.setOrder(order); // Set the order reference
            orderDetails.add(orderDetail);
        }

        order.setOrderDetails(orderDetails);
        orderRepository.save(order);

        // Create the OrderDto to return
        return mapOrderToDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(mapOrderToDto(order));
        }
        return orderDtos;
    }

    @Override
    public OrderDto getOrderById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapOrderToDto(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    private OrderDto mapOrderToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUser().getId()); // Assuming User has getId()
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setTotalAmount(order.getTotalAmount());

        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            OrderDetailDto detailDto = new OrderDetailDto();
            detailDto.setId(orderDetail.getId());
            detailDto.setOrderId(order.getId());
            detailDto.setItemId(orderDetail.getItem().getId()); // Assuming Item has getId()
            detailDto.setQuantity(orderDetail.getQuantity());
            detailDto.setPrice(orderDetail.getPrice());
            orderDetailDtos.add(detailDto);
        }
        orderDto.setOrderDetails(orderDetailDtos);
        return orderDto;
    }
}
