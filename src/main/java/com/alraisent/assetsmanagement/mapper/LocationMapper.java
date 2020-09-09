package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.LocationDto;
import com.alraisent.assetsmanagement.entity.Location;
import com.alraisent.assetsmanagement.request.LocationRequest;
import com.alraisent.assetsmanagement.response.LocationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location dtoToEntity(LocationDto locationDto);

    LocationDto entityToDto(Location location);

    LocationResponse dtoToResponse(LocationDto locationDto);

    LocationDto requestToDto(LocationRequest locationRequest);

}
