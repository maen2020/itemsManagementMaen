package com.maen.project_api.repository;

import com.maen.project_api.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findByNameContainingIgnoreCase(String name);
}
