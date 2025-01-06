package com.pizzaorder.service;

import com.pizzaorder.dto.request.CustomerRequestDto;
import com.pizzaorder.dto.response.CustomerResponseDto;
import com.pizzaorder.mapper.CustomerRequestMapper;
import com.pizzaorder.mapper.CustomerResponseMapper;
import com.pizzaorder.model.CustomerEntity;
import com.pizzaorder.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {


    private CustomerRepository customerRepository;

    private CustomerResponseMapper customerResponseMapper;

    private CustomerRequestMapper customerRequestMapper;

    public List<CustomerResponseDto> listAllCustomers(){

        return customerResponseMapper.getDtoListFromEntityList(customerRepository.findAll());
    }

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto){
        CustomerEntity customerEntity = customerRequestMapper.getEntityFromDto(customerRequestDto);
        return customerResponseMapper.getDtoFromEntity(customerRepository.save(customerEntity));
    }


}
