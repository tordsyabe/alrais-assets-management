package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.dto.AssetDto;
import com.alraisent.assetsmanagement.mapper.AssetMapper;
import com.alraisent.assetsmanagement.request.AssetRequest;
import com.alraisent.assetsmanagement.response.AssetResponse;
import com.alraisent.assetsmanagement.service.AssetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/assets")
public class AssetController {

    private final AssetService assetService;
    private final AssetMapper assetMapper;

    public AssetController(AssetService assetService, AssetMapper assetMapper) {
        this.assetService = assetService;
        this.assetMapper = assetMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AssetResponse> showAllAssets() {

        List<AssetResponse> assetResponseList = new ArrayList<>();

        assetService.getAssets().forEach(assetDto -> assetResponseList
                .add(assetMapper.dtoToResponse(assetDto)));

        return assetResponseList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssetResponse showAsset(@PathVariable String id) {

        return assetMapper.dtoToResponse(assetService.getAssetById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AssetResponse saveAsset(@RequestBody AssetRequest assetRequest) {

        AssetDto assetDto = assetMapper.requestToDto(assetRequest);

        AssetDto saveAsset = assetService.saveAsset(assetDto);

        return assetMapper.dtoToResponse(saveAsset);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAsset(@PathVariable String id) {
        assetService.deleteAsset(id);
    }
}
