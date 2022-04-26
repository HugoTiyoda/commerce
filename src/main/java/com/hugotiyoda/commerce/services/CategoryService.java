package com.hugotiyoda.commerce.services;

import com.hugotiyoda.commerce.entities.Category;
import com.hugotiyoda.commerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //getAll
    public Page<Category> findAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    //getByID
    public Category findCategoryByID(Long categoryId) {

        return categoryRepository.findById(categoryId).orElse(null);
    }

    //post
    public Category insertNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    //update
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    //delete
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
