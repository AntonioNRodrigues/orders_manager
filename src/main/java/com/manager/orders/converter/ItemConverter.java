package com.manager.orders.converter;

import com.manager.orders.models.dto.ItemDto;
import com.manager.orders.models.entities.Item;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter implements IConverter<Item, ItemDto> {

    @Override
    public ItemDto entityToDto(Item entity) {
        return new ItemDto(entity.getName(), entity.getId());
    }

    @Override
    public Item dtoToEntity(ItemDto dto) {
        Item item = new Item();
        BeanUtils.copyProperties(item, dto);
        return item;
    }
}
