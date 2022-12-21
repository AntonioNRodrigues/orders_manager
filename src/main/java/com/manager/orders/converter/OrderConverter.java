package com.manager.orders.converter;

import com.manager.orders.models.dto.OrderDto;
import com.manager.orders.models.entities.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter implements IConverter<Order, OrderDto> {
    @Override
    public OrderDto entityToDto(Order entity) {
        return new OrderDto(entity.getCreationDate(), entity.getQuantity(), entity.getUser().getEmail(), entity.getId(),
                entity.getItem().getId());
    }

    @Override
    public Order dtoToEntity(OrderDto dto) {
        Order order = new Order();
        BeanUtils.copyProperties(dto, order);
        return order;
    }
}
