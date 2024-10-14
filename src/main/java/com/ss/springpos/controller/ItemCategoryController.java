package com.ss.springpos.controller;


import com.ss.springpos.entity.ItemCategory;
import com.ss.springpos.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @PostMapping("/itemCate")
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory){
        ItemCategory createdItemCategory = itemCategoryService.createItemCategory(itemCategory);

        return ResponseEntity.status(201).body(createdItemCategory);
    }
}
