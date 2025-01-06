package com.pizzaorder.dto.response;


import java.util.List;
import java.util.UUID;

public record CustomerResponseDto(UUID id, String name, String address, List<OrderResponseDto> orders) {
}
