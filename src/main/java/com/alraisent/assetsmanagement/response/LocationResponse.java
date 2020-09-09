package com.alraisent.assetsmanagement.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LocationResponse {

    private String uuid;

    private String name;

    private String address;

    private String city;
}
