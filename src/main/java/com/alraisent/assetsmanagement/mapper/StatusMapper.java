package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.StatusDto;
import com.alraisent.assetsmanagement.entity.Status;
import com.alraisent.assetsmanagement.request.StatusRequest;
import com.alraisent.assetsmanagement.response.StatusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    StatusDto entityToDto(Status status);

    Status dtoToEntity(StatusDto statusDto);

    StatusResponse dtoToResponse(StatusDto statusDto);

    StatusDto requestToDto(StatusRequest statusRequest);
}
