package com.manager.orders.models.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.manager.orders.models.entities.Order} entity
 */
public class OrderDto implements Serializable {
    private final Instant creationDate;
    private final Integer quantity;
    private final String userEmail;
    private final Long orderId;
    private final Long itemId;

    public OrderDto(Instant creationDate, Integer quantity, String userEmail, Long orderId, Long itemId) {
        this.creationDate = creationDate;
        this.quantity = quantity;
        this.userEmail = userEmail;
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(creationDate, orderDto.creationDate) && Objects.equals(quantity, orderDto.quantity) && Objects.equals(userEmail, orderDto.userEmail) && Objects.equals(orderId, orderDto.orderId) && Objects.equals(itemId, orderDto.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, quantity, userEmail, orderId, itemId);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "creationDate=" + creationDate +
                ", quantity=" + quantity +
                ", userEmail='" + userEmail + '\'' +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }
}