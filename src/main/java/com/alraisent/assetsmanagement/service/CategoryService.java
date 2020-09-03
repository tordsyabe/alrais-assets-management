package com.alraisent.assetsmanagement.service;


import com.alraisent.assetsmanagement.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategories();
}
