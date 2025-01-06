package com.pizzaorder.controller;

import com.pizzaorder.dto.request.CustomerRequestDto;
import com.pizzaorder.dto.response.CustomerResponseDto;

import com.pizzaorder.service.CustomerService;
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
public class CustomerController {

    private CustomerService customerService;

    @RequestMapping(value = "/customer/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerResponseDto> listAllCustomers() {
        return customerService.listAllCustomers();
    }

    @RequestMapping(value = "/customer/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponseDto addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.addCustomer(customerRequestDto);
    }


}
