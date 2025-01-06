package com.pizzaorder.service;

import com.pizzaorder.dto.request.PizzaRequestDto;
import com.pizzaorder.dto.response.PizzaResponseDto;
import com.pizzaorder.mapper.PizzaRequestMapper;
import com.pizzaorder.mapper.PizzaResponseMapper;
import com.pizzaorder.repository.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;

    private PizzaRequestMapper pizzaRequestMapper;

    private PizzaResponseMapper pizzaResponseMapper;


    public List<PizzaResponseDto> listAllPizzas(){
        return pizzaResponseMapper.getDtoListFromEntityList(pizzaRepository.findAll());
    }

    public PizzaResponseDto addPizza(PizzaRequestDto pizzaRequestDto){
        return pizzaResponseMapper.getDtoFromEntity(pizzaRepository.save(pizzaRequestMapper.getEntityFromDto(pizzaRequestDto)));
    }
}
