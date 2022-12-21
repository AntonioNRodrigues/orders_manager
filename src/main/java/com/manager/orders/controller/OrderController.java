package com.manager.orders.controller;

import com.manager.orders.models.dto.OrderDto;
import com.manager.orders.services.OrderService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public OrderDto getOrder(@PathVariable long id) {
        return orderService.getOrder(id);
    }

    @PostMapping(path = "/order", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @DeleteMapping("/order/{id}")
    public Boolean deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }

    @PutMapping(value = "/order", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderService.updateOrder(orderDto);
    }


}
