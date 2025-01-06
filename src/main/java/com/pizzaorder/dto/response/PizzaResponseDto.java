package com.pizzaorder.dto.response;

import java.util.UUID;

public record PizzaResponseDto(UUID id, String name, Double price) {
}
