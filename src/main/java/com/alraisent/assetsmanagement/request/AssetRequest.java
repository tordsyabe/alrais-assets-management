package com.alraisent.assetsmanagement.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AssetRequest {

    private String uuid;

    private String assetTag;

    private String serial;

    private String name;

    private String purchaseDate;

    private String purchaseNumber;

    private String purchaseCost;

    private int warranty;

    private String notes;

    private String locationId;

    private String statusId;

    private String modelId;

    private String image;
}
