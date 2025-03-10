package com.ss.springpos.controller;

import com.ss.springpos.dto.ItemDto;
import com.ss.springpos.entity.Item;
import com.ss.springpos.entity.ItemCategory;
import com.ss.springpos.service.ItemCategoryService;
import com.ss.springpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemDto itemDTO){
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setDescription(itemDTO.getDescription());

        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemDTO.getItemCateId());
        item.setItemCategory(itemCategory);

        Item createItem = itemService.createItem(item);

        return  ResponseEntity.status(201).body(createItem);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();

        return ResponseEntity.status(200).body(items);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item item = itemService.getItemById(id);

        if (item == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDTO){
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setDescription(itemDTO.getDescription());

        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemDTO.getItemCateId());
        item.setItemCategory(itemCategory);

        Item updateItem = itemService.updateItem(id, item);

        return ResponseEntity.status(200).body(updateItem);
    }
}
