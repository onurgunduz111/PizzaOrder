package com.pizzaorder.mapper;

import com.pizzaorder.dto.OrderPizzaDto;
import com.pizzaorder.model.OrderPizzaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OrderPizzaMapper {

    List<OrderPizzaDto> getDtoListFromEntityList(List<OrderPizzaEntity> orderPizzaDto);

    OrderPizzaEntity getEntityFromDto(OrderPizzaDto orderPizzaDto);

    OrderPizzaDto getDtoFromEntity(OrderPizzaEntity orderPizzaEntity);
}
