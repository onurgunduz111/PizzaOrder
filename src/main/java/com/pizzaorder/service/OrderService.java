package com.pizzaorder.service;

import com.pizzaorder.dto.request.OrderRequestDto;
import com.pizzaorder.dto.response.OrderResponseDto;
import com.pizzaorder.mapper.OrderRequestMapper;
import com.pizzaorder.mapper.OrderResponseMapper;
import com.pizzaorder.model.CustomerEntity;
import com.pizzaorder.model.OrderEntity;

import com.pizzaorder.repository.CustomerRepository;
import com.pizzaorder.repository.OrderRepository;
import com.pizzaorder.repository.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Service
@AllArgsConstructor
public class OrderService {

    private OrderResponseMapper orderResponseMapper;

    private OrderRequestMapper orderRequestMapper;

    private OrderRepository orderRepository;

    private CustomerRepository customerRepository;

    private PizzaRepository pizzaRepository;

    public List<OrderResponseDto> listAllOrders(){
        return orderResponseMapper.getDtoListFromEntityList(orderRepository.findAll());
    }

    @Transactional
    public OrderResponseDto addOrder(OrderRequestDto orderRequestDto){
        CustomerEntity customerEntity = customerRepository.findById(orderRequestDto.customerId()).orElseThrow(EntityNotFoundException::new);

        OrderEntity orderEntity = orderRequestMapper.getEntityFromDto(orderRequestDto);

       boolean idNotExists = orderEntity.getOrderPizzas().stream().anyMatch(orderPizzaEntity -> !pizzaRepository.existsById(orderPizzaEntity.getPizzaId()));
       if(idNotExists)
           throw new IllegalArgumentException("Pizza does not exist!");

        orderEntity.setCustomerEntity(customerEntity);
        orderEntity.setCreationDate(new Date());
        OrderEntity persisted = orderRepository.save(orderEntity);

        return orderResponseMapper.getDtoFromEntity(persisted);
    }
}
