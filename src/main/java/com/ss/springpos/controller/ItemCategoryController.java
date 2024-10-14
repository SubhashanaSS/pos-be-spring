package com.ss.springpos.controller;


import com.ss.springpos.entity.ItemCategory;
import com.ss.springpos.service.ItemCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    public ItemCategoryController(ItemCategoryService itemCategoryService){
        this.itemCategoryService = itemCategoryService;
    }

    @PostMapping("/itemCate")
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory){
        ItemCategory createdItemCategory = itemCategoryService.createItemCategory(itemCategory);

        return ResponseEntity.status(201).body(createdItemCategory);
    }

    @GetMapping("/itemCate")
    public ResponseEntity<List<ItemCategory>> getAllItemCategories(){
        List<ItemCategory> itemCategories = itemCategoryService.getAllItemCategories();

        return ResponseEntity.status(200).body(itemCategories);
    }

    @GetMapping("/itemCate/{id}")
    public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable Long id){
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(id);

        if (itemCategory == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(itemCategory);

    }
}
