package com.ss.springpos.service;

import com.ss.springpos.entity.Item;

import java.util.List;

public interface ItemService {

    Item createItem(Item item);
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item updateItem(Long id, Item item);

    //void deleteItem(Long id);
}
