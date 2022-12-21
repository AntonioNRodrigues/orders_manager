package com.manager.orders.services;

import com.manager.orders.converter.OrderConverter;
import com.manager.orders.models.dto.OrderDto;
import com.manager.orders.models.entities.Item;
import com.manager.orders.models.entities.Order;
import com.manager.orders.models.entities.StockMovement;
import com.manager.orders.models.entities.User;
import com.manager.orders.repository.ItemRepository;
import com.manager.orders.repository.OrderRepository;
import com.manager.orders.repository.StockMovementRepository;
import com.manager.orders.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final OrderConverter orderConverter;
    private final ItemRepository itemRepository;
    private final StockMovementRepository stockMovementRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, OrderConverter orderConverter,
                        ItemRepository itemRepository, StockMovementRepository stockMovementRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderConverter = orderConverter;
        this.itemRepository = itemRepository;
        this.stockMovementRepository = stockMovementRepository;
    }


    public OrderDto getOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(orderConverter::entityToDto).orElse(null);
    }

    public boolean deleteOrder(Long id) {
        boolean actionReturn = false;
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.delete(order.get());
            actionReturn = true;
        }
        return actionReturn;
    }

    public OrderDto updateOrder(OrderDto orderDto) {
        Optional<Order> order = orderRepository.findById(orderDto.getOrderId());
        if (order.isPresent()) {
            Order o = order.get();
            o.setQuantity(orderDto.getQuantity());
            return orderConverter.entityToDto(o);
        } else {
            return null;
        }

    }

    public OrderDto addOrder(OrderDto orderDto) {
        Order order = orderConverter.dtoToEntity(orderDto);
        User user = userRepository.getUserByEmail(orderDto.getUserEmail());
        order.setUser(user);
        Item item = itemRepository.getReferenceById(orderDto.getItemId());
        order.setItem(item);
        order = orderRepository.save(order);
        satisfyOrder(order);
        return orderConverter.entityToDto(order);
    }

    private void satisfyOrder(Order order) {
        Optional<StockMovement> stockMovement = stockMovementRepository.getLastStockMovement(order.getItem().getId());

        if (stockMovement.isPresent()){

        }


        Stock stock = stockRepository.findByItem(order.getItem());
        if (stock.getCurrentStock() - order.getQuantity() >= 0) {
            order.setState(Boolean.TRUE);
            stock.setCurrentStock(stock.getCurrentStock() - order.getQuantity());
        }


    }


}
