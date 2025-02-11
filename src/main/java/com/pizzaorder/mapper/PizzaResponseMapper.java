package com.pizzaorder.mapper;

import com.pizzaorder.dto.response.PizzaResponseDto;
import com.pizzaorder.model.PizzaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PizzaResponseMapper {

    List<PizzaResponseDto> getDtoListFromEntityList(List<PizzaEntity> pizzaEntityList);

    PizzaResponseDto getDtoFromEntity(PizzaEntity pizzaEntity);
}
