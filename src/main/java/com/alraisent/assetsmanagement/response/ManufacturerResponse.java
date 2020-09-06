package com.alraisent.assetsmanagement.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManufacturerResponse {

    private String uuid;

    private String name;

    private String image;

    private String website;

    private String supportUrl;

    private String supportPhone;

    private String supportEmail;
}
