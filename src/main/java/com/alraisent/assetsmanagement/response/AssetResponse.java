package com.alraisent.assetsmanagement.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AssetResponse {

    private String uuid;

    private String assetTag;

    private String serial;

    private String name;

    private String purchaseDate;

    private String purchaseNumber;

    private String purchaseCost;

    private int warranty;

    private String notes;

    private LocationResponse locationResponse;

    private StatusResponse statusResponse;

    private ModelResponse modelResponse;

    private String image;
}
