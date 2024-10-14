package com.ss.springpos.service;

import com.ss.springpos.entity.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    ItemCategory createItemCategory(ItemCategory itemCategory);
    List<ItemCategory> getAllItemCategories();
    ItemCategory getItemCategoryById(Long id);
}
