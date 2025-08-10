package com.maen.ItemStoreAPI.service;

import com.maen.ItemStoreAPI.entities.Item;

import java.util.List;
import java.util.Optional;

public interface IItemService {
    // Obtener todos los items
    List<Item> getAllItems();
    // Obtener un item por su ID
    Optional<Item> getItemById(Long id);
    // Buscar items por nombre (ignorando mayúsculas y minúsculas)
    List<Item> findByNameContainingIgnoreCase(String name);
}