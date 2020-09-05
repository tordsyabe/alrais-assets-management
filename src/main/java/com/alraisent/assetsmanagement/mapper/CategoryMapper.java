package com.alraisent.assetsmanagement.mapper;

import com.alraisent.assetsmanagement.dto.CategoryDto;
import com.alraisent.assetsmanagement.entity.Category;
import com.alraisent.assetsmanagement.request.CategoryRequest;
import com.alraisent.assetsmanagement.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category dtoToEntity(CategoryDto categoryDto);

    CategoryDto entityToDto(Category category);

    CategoryResponse dtoToResponse(CategoryDto categoryDto);

    CategoryDto requestToDto(CategoryRequest categoryRequest);
}
