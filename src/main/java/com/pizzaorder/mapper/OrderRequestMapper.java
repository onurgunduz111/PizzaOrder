package com.pizzaorder.mapper;

import com.pizzaorder.dto.request.OrderRequestDto;
import com.pizzaorder.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OrderRequestMapper {

    OrderEntity getEntityFromDto(OrderRequestDto orderRequestDto);

    List<OrderEntity> getDtoListFromEntityList(List<OrderEntity> orderEntityList);
}
