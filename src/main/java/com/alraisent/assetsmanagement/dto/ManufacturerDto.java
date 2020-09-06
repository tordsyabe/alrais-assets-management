package com.alraisent.assetsmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManufacturerDto extends BaseDto {

    private String name;

    private String image;

    private String website;

    private String supportUrl;

    private String supportPhone;

    private String supportEmail;

}
