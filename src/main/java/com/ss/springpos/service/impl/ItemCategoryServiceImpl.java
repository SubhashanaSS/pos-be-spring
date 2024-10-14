package com.ss.springpos.service.impl;

import com.ss.springpos.entity.ItemCategory;
import com.ss.springpos.repository.ItemCategoryRepository;
import com.ss.springpos.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory){
        return itemCategoryRepository.save(itemCategory);
    }
}
