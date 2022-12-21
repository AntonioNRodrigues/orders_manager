package com.manager.orders.controller;

import com.manager.orders.models.dto.StockMovementDto;
import com.manager.orders.services.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class StockMovementController {

    private final StockMovementService stockMovementService;

    @Autowired
    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping("/stock_movement/{id}")
    public StockMovementDto getStockMovement(@PathVariable long id) {
        return stockMovementService.getStockMovement(id);
    }

    @PostMapping(path = "/stock_movement", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public StockMovementDto addItem(@RequestBody StockMovementDto stockMovementDto) {
        return stockMovementService.addStockMovement(stockMovementDto);
    }

    @DeleteMapping("/stock_movement/{id}")
    public Boolean deleteItem(@PathVariable Long id) {
        return stockMovementService.deleteStockMovement(id);
    }

    @PutMapping(value = "/stock_movement", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public StockMovementDto updateItem(@RequestBody StockMovementDto stockMovementDto) {
        return stockMovementService.updateStockMovement(stockMovementDto);
    }


}
