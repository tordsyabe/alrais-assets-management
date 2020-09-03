package com.alraisent.assetsmanagement.dto;

import com.alraisent.assetsmanagement.entity.Category;
import com.alraisent.assetsmanagement.entity.Manufacturer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelDto extends BaseDto {

    private String name;

//    private ManufacturerDto manufacturerDto;
//
//    private CategoryDto categoryDto;

    private String modelNumber;
}
