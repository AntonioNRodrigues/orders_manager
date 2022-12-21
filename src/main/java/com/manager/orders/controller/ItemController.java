package com.manager.orders.controller;

import com.manager.orders.models.dto.ItemDto;
import com.manager.orders.services.ItemService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item/{id}")
    public ItemDto getItem(@PathVariable long id) {
        return itemService.getItem(id);
    }

    @PostMapping(path = "/item", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ItemDto addItem(@RequestBody ItemDto itemDto) {
        return itemService.addItem(itemDto);
    }

    @DeleteMapping("/item/{id}")
    public Boolean deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }

    @PutMapping(value = "/item", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ItemDto updateItem(@RequestBody ItemDto itemDto) {
        return itemService.updateItem(itemDto);
    }


}
