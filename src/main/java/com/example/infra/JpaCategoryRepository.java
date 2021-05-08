package com.example.infra;

import com.example.domain.Category;
import com.example.repository.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository
        extends CategoryRepository, JpaRepository<Category, Long> {
    Category save(Category category);
}
