package com.maen.ItemStoreAPI.persistence.impl;

import com.maen.ItemStoreAPI.entities.Item;
import com.maen.ItemStoreAPI.persistence.ItemsDAO;
import com.maen.ItemStoreAPI.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemDAOImpl implements ItemsDAO {
    // Inyección de dependencias del repositorio de items
    private final ItemRepository itemRepository;

    // Constructor para inyectar el repositorio de items
    public ItemDAOImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Implementación de los métodos de la interfaz ItemsDAO
    @Override
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public List<Item> findByNameContainingIgnoreCase(String name) {
        return itemRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }
}
