package com.maen.ItemStoreAPI.controllers;

import com.maen.ItemStoreAPI.controllers.dto.ItemDTO;
import com.maen.ItemStoreAPI.entities.Item;
import com.maen.ItemStoreAPI.service.IItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final IItemService itemService;

    public ItemController(IItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        Optional<Item> itemOptional = itemService.getItemById(id);

        if (itemOptional.isPresent()){
            Item item = itemOptional.get();

            ItemDTO itemDTO = new ItemDTO.Builder()
                    .id(item.getId())
                    .name(item.getName())
                    .description(item.getDescription())
                    .price(item.getPrice())
                    .sku(item.getSku())
                    .build();
            return ResponseEntity.ok(itemDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchByName(@RequestParam String name){
        List<Item> items = itemService.findByNameContainingIgnoreCase(name);
        if (items.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(itemService.findByNameContainingIgnoreCase(name));
        }
    }
}