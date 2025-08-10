package com.maen.ItemStoreAPI.service.impl;

import com.maen.ItemStoreAPI.entities.Item;
import com.maen.ItemStoreAPI.persistence.ItemsDAO;
import com.maen.ItemStoreAPI.service.IItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements IItemService {

    private final ItemsDAO itemsDAO;
    public ItemServiceImpl(ItemsDAO itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Override
    public List<Item> getAllItems() {
        return itemsDAO.getAllItems();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemsDAO.getItemById(id);
    }

    @Override
    public List<Item> findByNameContainingIgnoreCase(String name) {
        return itemsDAO.findByNameContainingIgnoreCase(name);
    }
}
