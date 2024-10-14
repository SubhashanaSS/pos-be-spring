package com.ss.springpos.service.impl;

import com.ss.springpos.entity.Item;
import com.ss.springpos.repository.ItemRepository;
import com.ss.springpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item){
        return itemRepository.save(item);
    }
}
