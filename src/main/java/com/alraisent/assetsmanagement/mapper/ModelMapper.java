package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.entity.Model;
import com.alraisent.assetsmanagement.request.ModelRequest;
import com.alraisent.assetsmanagement.response.ModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CategoryMapper.class, ManufacturerMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "category", source = "modelDto.categoryDto")
    @Mapping(target = "manufacturer", source = "modelDto.manufacturerDto")
    Model dtoToEntity(ModelDto modelDto);

    @Mapping(target = "categoryDto", source = "model.category")
    @Mapping(target = "manufacturerDto", source = "model.manufacturer")
    ModelDto entityToDto(Model model);

    @Mapping(target = "categoryResponse", source = "modelDto.categoryDto")
    @Mapping(target = "manufacturerResponse", source = "modelDto.manufacturerDto")
    ModelResponse dtoToResponse(ModelDto modelDto);

    ModelDto requestToDto(ModelRequest modelRequest);
}
