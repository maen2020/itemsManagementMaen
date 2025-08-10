package com.maen.ItemStoreAPI.persistence;

import com.maen.ItemStoreAPI.entities.Item;

import java.util.List;
import java.util.Optional;

public interface ItemsDAO {

    // Obtener todos los items
    List<Item> getAllItems();

    // Buscar items por nombre (ignorando mayúsculas y minúsculas)
    List<Item> findByNameContainingIgnoreCase(String name);

    // Obtener un item por su ID
    Optional<Item> getItemById(Long id);
}