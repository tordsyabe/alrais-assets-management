package com.alraisent.assetsmanagement.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AssetDto extends BaseDto {

    private String assetTag;

    private String serial;

    private String name;

    private LocalDate purchaseDate;

    private String purchaseNumber;

    private String purchaseCost;

    private int warranty;

    private String notes;

    private LocationDto LocationDto;

    private StatusDto statusDto;

    private ModelDto modelDto;

    private String locationId;

    private String statusId;

    private String modelId;

    private String image;
}
