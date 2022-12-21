package com.manager.orders.services;

import com.manager.orders.converter.ItemConverter;
import com.manager.orders.models.dto.ItemDto;
import com.manager.orders.models.dto.OrderDto;
import com.manager.orders.models.entities.Item;
import com.manager.orders.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemConverter itemConverter;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemConverter itemConverter) {
        this.itemRepository = itemRepository;
        this.itemConverter = itemConverter;
    }


    public ItemDto getItem(long id) {
        Item item = itemRepository.getReferenceById(id);
        return itemConverter.entityToDto(item);
    }

    public ItemDto addItem(ItemDto itemDto) {
        Item item = itemConverter.dtoToEntity(itemDto);
        item = itemRepository.save(item);
        return itemConverter.entityToDto(item);
    }

    public Boolean deleteItem(Long id) {
        boolean actionReturn = false;
        Item item = itemRepository.getReferenceById(id);
        return null;


    }

    public ItemDto updateItem(ItemDto itemDto) {
        return null;
    }
}
