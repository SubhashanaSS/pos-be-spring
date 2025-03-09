package com.ss.springpos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ss.springpos.entity.Stock;

@Service
public interface StockService {
    Stock createStock(Stock stock);
    Stock updateStock(int id, Stock stock);
    void deleteStock(int id);
    Stock getStockById(int id);
    List<Stock> getAllStock();
}
