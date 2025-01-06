package com.pizzaorder.repository;

import com.pizzaorder.model.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PizzaRepository extends JpaRepository<PizzaEntity, UUID> {
}

