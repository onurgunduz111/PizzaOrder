package com.pizzaorder.repository;

import com.pizzaorder.model.OrderPizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderPizzaRepository extends JpaRepository<OrderPizzaEntity, UUID> {
}
