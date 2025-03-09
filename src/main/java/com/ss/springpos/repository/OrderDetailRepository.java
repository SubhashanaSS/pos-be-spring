package com.ss.springpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.springpos.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
    
}
