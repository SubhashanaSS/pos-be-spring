package com.ss.springpos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.springpos.dto.StockDto;
import com.ss.springpos.entity.Item;
import com.ss.springpos.entity.Stock;
import com.ss.springpos.service.ItemService;
import com.ss.springpos.service.StockService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stock")
public class StockController {
     @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStock() {
        List<Stock> stocks = stockService.getAllStock();
        return ResponseEntity.status(200).body(stocks);
    }

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody StockDto stockDto) {
        Stock stock = new Stock();
        stock.setId(stockDto.getId());
        stock.setQuantity(stockDto.getQuantity());

        Item itemById = itemService.getItemById(stockDto.getItemId());
        stock.setItem(itemById);

        Stock createdStock = stockService.createStock(stock);
        return ResponseEntity.status(201).body(createdStock);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable int id, @RequestBody StockDto stockDto) {
        Stock stock = new Stock();
        stock.setId(id);

        Item itemById = itemService.getItemById(stockDto.getItemById());
        stock.setItem(itemById);

        Stock updateStock = stockService.updateStock(id, stock);
        return ResponseEntity.status(201).body(updateStock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable int id) {
        stockService.deleteStock(id);
        return ResponseEntity.status(200).body("Stock deleted");
    }

}
