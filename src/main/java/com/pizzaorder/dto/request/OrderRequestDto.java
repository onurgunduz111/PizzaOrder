package com.pizzaorder.dto.request;


import com.pizzaorder.dto.OrderPizzaDto;

import java.util.List;
import java.util.UUID;

public record OrderRequestDto(UUID customerId, List<OrderPizzaDto> orderPizzas) {
}
