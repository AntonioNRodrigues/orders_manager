package com.manager.orders.services;

import com.manager.orders.converter.StockMovementConverter;
import com.manager.orders.models.dto.StockMovementDto;
import com.manager.orders.models.entities.StockMovement;
import com.manager.orders.repository.StockMovementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockMovementService {


    private final Logger logger = LoggerFactory.getLogger(StockMovementService.class);
    private final StockMovementRepository stockMovementRepository;

    private final StockMovementConverter stockMovementConverter;

    @Autowired
    public StockMovementService(StockMovementRepository stockMovementRepository, StockMovementConverter stockMovementConverter) {
        this.stockMovementRepository = stockMovementRepository;
        this.stockMovementConverter = stockMovementConverter;
    }


    public StockMovementDto getStockMovement(long id) {
        Optional<StockMovement> stockMovement = stockMovementRepository.findById(id);
        return stockMovement.map(stockMovementConverter::entityToDto).orElse(null);
    }

    public boolean deleteStockMovement(Long id) {
        boolean actionReturn = false;
        Optional<StockMovement> stockMovement = stockMovementRepository.findById(id);

        if (stockMovement.isPresent()) {
            stockMovementRepository.delete(stockMovement.get());
            actionReturn = true;
        }
        return actionReturn;
    }

    public StockMovementDto updateStockMovement(StockMovementDto stockMovementDto) {
        Optional<StockMovement> stockMovement = stockMovementRepository.findById(stockMovementDto.getStockMovementId());
        if (stockMovement.isPresent()) {
            stockMovement.get().setCreationDate(stockMovementDto.getCreationDate());
            //stockMovement.get().setItem(stockMovementDto.getItem());
            stockMovement.get().setQuantity(stockMovementDto.getQuantity());
            StockMovement uddatedStockMovement = stockMovementRepository.save(stockMovement.get());
            return stockMovementConverter.entityToDto(uddatedStockMovement);
        } else {
            return null;
        }
    }

    public StockMovementDto addStockMovement(StockMovementDto stockMovementDt) {
        StockMovement stockMovement = stockMovementRepository.save(stockMovementConverter.dtoToEntity(stockMovementDt));
        return stockMovementConverter.entityToDto(stockMovement);
    }


}
