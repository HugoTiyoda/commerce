package com.hugotiyoda.commerce.services;

import com.hugotiyoda.commerce.entities.Category;
import com.hugotiyoda.commerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class categoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //all
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }


    //byId
    public Category getCaregoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    //

}
