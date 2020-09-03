package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.entity.Model;
import com.alraisent.assetsmanagement.response.CategoryResponse;
import com.alraisent.assetsmanagement.response.ModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CategoryMapper.class, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(target = "category", source = "modelDto.categoryDto")
    Model dtoToEntity(ModelDto modelDto);

    @Mapping(target = "categoryDto", source = "model.category")
    ModelDto entityToDto(Model model);

    @Mapping(target = "categoryResponse", source = "modelDto.categoryDto")
    ModelResponse dtoToResponse(ModelDto modelDto);
}
