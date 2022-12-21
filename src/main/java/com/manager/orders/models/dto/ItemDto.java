package com.manager.orders.models.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.manager.orders.models.entities.Item} entity
 */
public class ItemDto implements Serializable {
    private final String name;

    private final Long itemId;

    public ItemDto(String name, Long itemId) {
        this.name = name; this.itemId = itemId;
    }

    public String getName() {
        return name;
    }


    public Long getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return Objects.equals(name, itemDto.name) && Objects.equals(itemId, itemDto.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, itemId);
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "name='" + name + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}