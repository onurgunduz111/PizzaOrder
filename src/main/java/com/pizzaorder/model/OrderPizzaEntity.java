package com.pizzaorder.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.UUID;


@Table(name = "order_pizza")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderPizzaEntity {

     @Id
     @Column(name = "id", updatable = false, nullable = false)
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

     /*@Column(name = "order_id", nullable = false)
     private UUID orderId;*/

     @Column(name = "pizza_id", nullable = false)
     private UUID pizzaId;

     @Column(name = "amount", nullable = false)
     private Integer amount;

}
