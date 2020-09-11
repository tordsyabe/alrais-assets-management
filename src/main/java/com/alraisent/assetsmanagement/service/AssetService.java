package com.alraisent.assetsmanagement.service;

import com.alraisent.assetsmanagement.dto.AssetDto;

import java.util.List;

public interface AssetService {

    List<AssetDto> getAssets();

    AssetDto getAssetById(String id);

    AssetDto saveAsset(AssetDto assetDto);

    void deleteAsset(String id);
}
