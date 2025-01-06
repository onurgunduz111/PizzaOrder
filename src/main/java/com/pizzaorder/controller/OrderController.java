package com.pizzaorder.controller;

import com.pizzaorder.dto.request.OrderRequestDto;
import com.pizzaorder.dto.response.OrderResponseDto;
import com.pizzaorder.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @RequestMapping(value = "/order/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderResponseDto> listAllOrders() {
        return orderService.listAllOrders();
    }

    @RequestMapping(value = "/order/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderResponseDto addOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.addOrder(orderRequestDto);
    }
}
