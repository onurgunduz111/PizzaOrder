package com.pizzaorder.mapper;

import com.pizzaorder.dto.request.CustomerRequestDto;
import com.pizzaorder.model.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerRequestMapper {

    CustomerEntity getEntityFromDto(CustomerRequestDto customerRequestDto);
}
