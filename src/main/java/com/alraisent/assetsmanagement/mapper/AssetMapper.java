package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.AssetDto;
import com.alraisent.assetsmanagement.entity.Asset;
import com.alraisent.assetsmanagement.request.AssetRequest;
import com.alraisent.assetsmanagement.response.AssetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {LocationMapper.class, StatusMapper.class, ModelMapper.class, }, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetMapper {

    AssetMapper INSTANCE = Mappers.getMapper(AssetMapper.class);

    @Mapping(target = "location", source = "assetDto.locationDto")
    @Mapping(target = "status", source = "assetDto.statusDto")
    @Mapping(target = "model", source = "assetDto.modelDto")
    Asset dtoToEntity(AssetDto assetDto);

    @Mapping(target = "locationDto", source = "asset.location")
    @Mapping(target = "statusDto", source = "asset.status")
    @Mapping(target = "modelDto", source = "asset.model")
    AssetDto entityToDto(Asset asset);

    @Mapping(target = "locationResponse", source = "assetDto.locationDto")
    @Mapping(target = "statusResponse", source = "assetDto.statusDto")
    @Mapping(target = "modelResponse", source = "assetDto.modelDto")
    @Mapping(target="purchaseDate", source = "assetDto.purchaseDate", dateFormat = "yyyy-MM-dd")
    AssetResponse dtoToResponse(AssetDto assetDto);

    @Mapping(target="purchaseDate", source = "assetRequest.purchaseDate", dateFormat = "yyyy-MM-dd")
    AssetDto requestToDto (AssetRequest assetRequest);
}
