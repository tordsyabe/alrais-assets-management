package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.CategoryDto;
import com.alraisent.assetsmanagement.entity.Category;
import com.alraisent.assetsmanagement.mapper.CategoryMapper;
import com.alraisent.assetsmanagement.repository.CategoryRepository;
import com.alraisent.assetsmanagement.service.CategoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getCategories() {

        List<CategoryDto> categoryDtoList = new ArrayList<>();

        categoryRepository.findAll().forEach(category -> categoryDtoList.add(categoryMapper.entityToDto(category)));

        return categoryDtoList;
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {

        Category category = categoryMapper.dtoToEntity(categoryDto);

        category.setCreatedAt(LocalDate.now());

        categoryRepository.save(category);

        return categoryMapper.entityToDto(categoryRepository.save(category));
    }
}
