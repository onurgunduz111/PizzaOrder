package com.pizzaorder.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Table(name = "order_pizza")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPizzaEntity {

     @Id
     @Column(name = "id", updatable = false, nullable = false)
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

     @Column(name = "pizza_id", nullable = false)
     private UUID pizzaId;

     @Column(name = "amount", nullable = false)
     private Integer amount;

}
