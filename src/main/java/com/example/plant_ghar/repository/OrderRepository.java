package com.example.plant_ghar.repository;

import com.example.plant_ghar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
