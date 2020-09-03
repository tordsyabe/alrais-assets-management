package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.entity.Model;
import com.alraisent.assetsmanagement.response.ModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    Model dtoToEntity(ModelDto modelDto);

    ModelDto entityToDto(Model model);

    ModelResponse dtoToResponse(ModelDto modelDto);
}
