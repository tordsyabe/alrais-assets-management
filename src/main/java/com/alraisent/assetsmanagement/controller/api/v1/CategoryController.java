package com.alraisent.assetsmanagement.controller.api.v1;

import com.alraisent.assetsmanagement.dto.CategoryDto;
import com.alraisent.assetsmanagement.mapper.CategoryMapper;
import com.alraisent.assetsmanagement.request.CategoryRequest;
import com.alraisent.assetsmanagement.response.CategoryResponse;
import com.alraisent.assetsmanagement.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> showAllCategories() {

        List<CategoryResponse> categoryResponseList = new ArrayList<>();

        categoryService.getCategories().forEach(categoryDto -> categoryResponseList
                .add(categoryMapper.dtoToResponse(categoryDto)));

        return categoryResponseList;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse showCategory(@PathVariable String id) {

        return categoryMapper.dtoToResponse(categoryService.getCategoryById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse saveCategory(@RequestBody CategoryRequest categoryRequest) {

        CategoryDto categoryDto = categoryMapper.requestToDto(categoryRequest);

        CategoryDto savedCategory = categoryService.saveCategory(categoryDto);

        return categoryMapper.dtoToResponse(savedCategory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
    }

}
