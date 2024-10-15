package com.ss.springpos.service.impl;

import com.ss.springpos.entity.Item;
import com.ss.springpos.repository.ItemRepository;
import com.ss.springpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id){
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, Item item){
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null){
            return null;
        } else {
            existingItem.setName(item.getName());
            existingItem.setPrice(item.getPrice());
            existingItem.setDescription(item.getDescription());
            existingItem.setItemCategory(item.getItemCategory());
        }

        return itemRepository.save(existingItem);
    }
}
