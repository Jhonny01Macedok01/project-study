package com.project1.project_study.services;

import com.project1.project_study.DTOs.CategoryDTO;
import com.project1.project_study.core.utils.ApiObjectMapper;
import com.project1.project_study.models.Category;
import com.project1.project_study.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ApiObjectMapper<Category> apiObjectMapper;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public void create (CategoryDTO categoryDTO) {
        var category = apiObjectMapper.dtoToModel(categoryDTO, Category.class);
        category.setCategoryName(categoryDTO.categoryName());
        categoryRepository.save(category);
    }

    public Category update(CategoryDTO categoryDTO, Long categoryId) {
        var category = findCategoryById(categoryId);
        return categoryRepository.save(category);
    }

    public Category findOne(Long categoryId) {
        return findCategoryById(categoryId);
    }

    public void delete(Long categoryId) {
        var category = findCategoryById(categoryId);
        categoryRepository.deleteById(category.getId());
    }

    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(RuntimeException::new);
    }
}

