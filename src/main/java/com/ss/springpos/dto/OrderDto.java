package com.ss.springpos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int id;
    private int userId;
    private LocalDate orderDate;
    private double totalAmount;
    private List<OrderDetailDto> orderDetails;
}
