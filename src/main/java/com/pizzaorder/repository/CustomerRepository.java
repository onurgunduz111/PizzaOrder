package com.pizzaorder.repository;

import com.pizzaorder.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
