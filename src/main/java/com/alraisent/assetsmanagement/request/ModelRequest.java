package com.alraisent.assetsmanagement.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelRequest {

    private String uuid;

    private String name;

    private String modelNumber;

    private String categoryId;

    private String manufacturerId;

}
