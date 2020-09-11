package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.AssetDto;
import com.alraisent.assetsmanagement.dto.LocationDto;
import com.alraisent.assetsmanagement.dto.ModelDto;
import com.alraisent.assetsmanagement.dto.StatusDto;
import com.alraisent.assetsmanagement.entity.Asset;
import com.alraisent.assetsmanagement.mapper.AssetMapper;
import com.alraisent.assetsmanagement.repository.AssetRepository;
import com.alraisent.assetsmanagement.service.AssetService;
import com.alraisent.assetsmanagement.service.LocationService;
import com.alraisent.assetsmanagement.service.ModelService;
import com.alraisent.assetsmanagement.service.StatusService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;
    private final LocationService locationService;
    private final ModelService modelService;
    private final StatusService statusService;

    public AssetServiceImpl(AssetRepository assetRepository, AssetMapper assetMapper, LocationService locationService, ModelService modelService, StatusService statusService) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
        this.locationService = locationService;
        this.modelService = modelService;
        this.statusService = statusService;
    }

    @Override
    public List<AssetDto> getAssets() {
        List<AssetDto> assetDtoList = new ArrayList<>();

        assetRepository.findAll().forEach(asset -> assetDtoList.add(assetMapper.entityToDto(asset)));

        return assetDtoList;
    }

    @Override
    public AssetDto getAssetById(String id) {
        return assetMapper.entityToDto(assetRepository.findByUuid(id));
    }

    @Override
    public AssetDto saveAsset(AssetDto assetDto) {

        LocationDto locationDto = locationService.getLocationById(assetDto.getLocationId());
        ModelDto modelDto = modelService.getModelById(assetDto.getModelId());
        StatusDto statusDto = statusService.getStatusById(assetDto.getStatusId());

        assetDto.setLocationDto(locationDto);
        assetDto.setModelDto(modelDto);
        assetDto.setStatusDto(statusDto);

        if(assetDto.getUuid() != null) {
            Asset assetFromDb = assetRepository.findByUuid(assetDto.getUuid());
            assetDto.setId(assetFromDb.getId());
            assetDto.setCreatedAt(assetFromDb.getCreatedAt());
            assetDto.setUpdatedAt(LocalDateTime.now());
            assetDto.setSerial(assetFromDb.getSerial());

            Asset savedAsset = assetRepository.save(assetMapper.dtoToEntity(assetDto));

            return assetMapper.entityToDto(savedAsset);
        }

        assetDto.setCreatedAt(LocalDateTime.now());

        assetDto.setUuid(UUID.randomUUID().toString());

        Asset savedAsset = assetRepository.save(assetMapper.dtoToEntity(assetDto));

        return assetMapper.entityToDto(savedAsset);
    }

    @Override
    public void deleteAsset(String id) {
        Asset assetToDelete = assetRepository.findByUuid(id);

        assetRepository.delete(assetToDelete);
    }
}
