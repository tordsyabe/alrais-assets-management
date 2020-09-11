package com.alraisent.assetsmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    private List<ModelDto> modelDtos = new ArrayList<>();

}
