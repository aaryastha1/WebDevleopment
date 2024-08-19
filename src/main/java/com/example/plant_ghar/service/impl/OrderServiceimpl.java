package com.example.plant_ghar.service.impl;


import com.example.plant_ghar.dto.OrderDto;
import com.example.plant_ghar.entity.Order;
import com.example.plant_ghar.repository.OrderRepository;
import com.example.plant_ghar.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderServiceimpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public String save(OrderDto orderDTO) {
        return null;
    }

    @Override
    public String createOrder(OrderDto orderDTO) {
        Order order = new Order();

        if (orderDTO.getId() != null) {
            order = orderRepository.findById(orderDTO.getId()).orElseThrow(() -> new NullPointerException("Order not found"));
        }

        order.setOrderName(orderDTO.getOrderName());
        order.setPrice(orderDTO.getPrice());
        order.setImageUrl(orderDTO.getImageUrl());
        order.setQuantity(orderDTO.getQuantity());
        order.setDescription(orderDTO.getDescription());

        orderRepository.save(order);

        return "Order created";
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderRepository.deleteById(id);
    }
}
