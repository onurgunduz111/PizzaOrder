package com.pizzaorder.dto.response;

import com.pizzaorder.dto.OrderPizzaDto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record OrderResponseDto(UUID id, Date creationDate, List<OrderPizzaDto> orderPizzas) {
}
