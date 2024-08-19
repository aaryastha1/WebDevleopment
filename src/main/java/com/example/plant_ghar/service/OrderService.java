package com.example.plant_ghar.service;

import com.example.plant_ghar.dto.OrderDto;
import com.example.plant_ghar.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    String save(OrderDto orderDTO);

    String createOrder(OrderDto orderDTO);

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Integer id);

    void deleteOrderById(Integer id);


}