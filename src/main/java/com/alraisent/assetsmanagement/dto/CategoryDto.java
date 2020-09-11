package com.alraisent.assetsmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto extends BaseDto {

    private String name;

    private String type;

    private List<ModelDto> modelDtos = new ArrayList<>();

}
