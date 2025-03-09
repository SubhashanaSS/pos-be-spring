package com.ss.springpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.springpos.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{
    
}
