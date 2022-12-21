package com.manager.orders.converter;

import com.manager.orders.models.dto.StockMovementDto;
import com.manager.orders.models.entities.StockMovement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StockMovementConverter implements IConverter<StockMovement, StockMovementDto> {
    @Override
    public StockMovementDto entityToDto(StockMovement entity) {
        return new StockMovementDto(entity.getCreationDate(), entity.getQuantity(), null, entity.getId());
    }

    @Override
    public StockMovement dtoToEntity(StockMovementDto dto) {
        StockMovement stockMovement = new StockMovement();
        BeanUtils.copyProperties(dto, stockMovement);
        return stockMovement;
    }
}
