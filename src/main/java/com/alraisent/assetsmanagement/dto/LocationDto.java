package com.alraisent.assetsmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LocationDto extends BaseDto {

    private String name;

    private String address;

    private String city;

    private List<AssetDto> assetDtos = new ArrayList<>();
}
