package com.alraisent.assetsmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StatusDto extends BaseDto{

    private String name;

    private String type;

    private String note;

    private List<AssetDto> assetDtos = new ArrayList<>();
}
