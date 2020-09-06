package com.alraisent.assetsmanagement.service.impl;

import com.alraisent.assetsmanagement.dto.CategoryDto;
import com.alraisent.assetsmanagement.entity.Category;
import com.alraisent.assetsmanagement.mapper.CategoryMapper;
import com.alraisent.assetsmanagement.repository.CategoryRepository;
import com.alraisent.assetsmanagement.service.CategoryService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public CategoryDto getCategoryById(String id) {

        return categoryMapper.entityToDto(categoryRepository.findByUuid(id));
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {

        Category category = categoryMapper.dtoToEntity(categoryDto);

        if(categoryDto.getUuid() != null) {
            Category categoryFromDb = categoryRepository.findByUuid(categoryDto.getUuid());
            category.setId(categoryFromDb.getId());
            category.setCreatedAt(categoryFromDb.getCreatedAt());
            category.setUpdatedAt(LocalDateTime.now());

            return categoryMapper.entityToDto(categoryRepository.save(category));
        }

        category.setCreatedAt(LocalDateTime.now());

        category.setUuid(UUID.randomUUID().toString());

        return categoryMapper.entityToDto(categoryRepository.save(category));

    }

    @Override
    public void deleteCategory(String id) {

        Category categoryToDelete = categoryRepository.findByUuid(id);

        categoryRepository.delete(categoryToDelete);
    }
}
