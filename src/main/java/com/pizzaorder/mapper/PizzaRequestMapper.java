package com.pizzaorder.mapper;

import com.pizzaorder.dto.request.PizzaRequestDto;
import com.pizzaorder.model.PizzaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PizzaRequestMapper {

    PizzaEntity getEntityFromDto(PizzaRequestDto pizzaRequestDto);

}
