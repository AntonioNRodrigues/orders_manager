package com.manager.orders.models.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.manager.orders.models.entities.StockMovement} entity
 */
public class StockMovementDto implements Serializable {
    private final Instant creationDate;
    private final Integer quantity;
    private final ItemDto item;

    private final Long stockMovementId;

    public StockMovementDto(Instant creationDate, Integer quantity, ItemDto item, Long stockMovementId) {
        this.creationDate = creationDate;
        this.quantity = quantity;
        this.item = item;
        this.stockMovementId = stockMovementId;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ItemDto getItem() {
        return item;
    }

    public Long getStockMovementId() {
        return stockMovementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockMovementDto that = (StockMovementDto) o;
        return Objects.equals(creationDate, that.creationDate) && Objects.equals(quantity, that.quantity) && Objects.equals(item, that.item) && Objects.equals(stockMovementId, that.stockMovementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, quantity, item, stockMovementId);
    }

    @Override
    public String toString() {
        return "StockMovementDto{" +
                "creationDate=" + creationDate +
                ", quantity=" + quantity +
                ", item=" + item +
                ", stockMovementId=" + stockMovementId +
                '}';
    }
}