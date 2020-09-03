package com.alraisent.assetsmanagement.repository;

import com.alraisent.assetsmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
