package com.pizzaorder.mapper;

import com.pizzaorder.dto.response.CustomerResponseDto;
import com.pizzaorder.model.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerResponseMapper {
    List<CustomerResponseDto> getDtoListFromEntityList(List<CustomerEntity> customer);

    CustomerEntity getEntityFromDto(CustomerResponseDto customerResponseDto);

    CustomerResponseDto getDtoFromEntity(CustomerEntity customerEntity);
}
