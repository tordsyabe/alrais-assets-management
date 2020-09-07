package com.alraisent.assetsmanagement.response;

import com.alraisent.assetsmanagement.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelResponse {

    private String uuid;

    private String name;

    private String modelNumber;

    private CategoryResponse categoryResponse;

    private ManufacturerResponse manufacturerResponse;

}
