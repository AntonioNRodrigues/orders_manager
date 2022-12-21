package com.manager.orders.repository;

import com.manager.orders.models.entities.StockMovement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long>, Pageable {

    @Query(value = "SELECT st FROM StockMovement st WHERE st.item = 1 order by st.creationDate desc LIMIT 1", nativeQuery = true)
    Optional<StockMovement> getLastStockMovement(Long itemId);

}