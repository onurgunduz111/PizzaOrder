package com.pizzaorder.controller;

import com.pizzaorder.dto.request.PizzaRequestDto;
import com.pizzaorder.dto.response.PizzaResponseDto;
import com.pizzaorder.service.PizzaService;
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
public class PizzaController { // Response Entity, Global Exception Handling, Mapstruct bean mapping, Open API Swagger, Lombok

    private PizzaService pizzaService;

    @RequestMapping(value = "/pizza/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PizzaResponseDto> listALLPizzas() {
        return pizzaService.listAllPizzas();
    }

    @RequestMapping(value = "/pizza/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PizzaResponseDto addCustomer(@RequestBody PizzaRequestDto pizzaRequestDto){
        return pizzaService.addPizza(pizzaRequestDto);
    }
}
