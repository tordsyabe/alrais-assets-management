package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.ManufacturerDto;
import com.alraisent.assetsmanagement.entity.Manufacturer;
import com.alraisent.assetsmanagement.request.ManufacturerRequest;
import com.alraisent.assetsmanagement.response.ManufacturerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ManufacturerMapper {

    ManufacturerMapper INSTANCE = Mappers.getMapper(ManufacturerMapper.class);

    Manufacturer dtoToEntity(ManufacturerDto manufacturerDto);

    ManufacturerDto entityToDto(Manufacturer manufacturer);

    ManufacturerResponse dtoToResponse(ManufacturerDto manufacturerDto);

    ManufacturerRequest dtoToRequest(ManufacturerDto manufacturerDto);
}
