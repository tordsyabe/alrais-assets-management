package com.alraisent.assetsmanagement.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationRequest {

    private String uuid;

    private String name;

    private String address;

    private String city;
}
