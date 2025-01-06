package com.pizzaorder.mapper;


import com.pizzaorder.dto.response.OrderResponseDto;
import com.pizzaorder.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OrderResponseMapper {

    //@Mapping(target = "customerId", source = "customerId")
    OrderResponseDto getDtoFromEntity(OrderEntity orderEntity);

    List<OrderResponseDto> getDtoListFromEntityList(List<OrderEntity> order);
}
