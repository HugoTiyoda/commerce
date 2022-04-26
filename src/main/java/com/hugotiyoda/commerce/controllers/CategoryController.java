package com.hugotiyoda.commerce.controllers;

import com.hugotiyoda.commerce.entities.Category;
import com.hugotiyoda.commerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> insertNewCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.insertNewCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Category>> getAllCategories(Pageable pageable) {
        return new ResponseEntity<>(categoryService.findAllCategory(pageable), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
        return new ResponseEntity<>(categoryService.findCategoryByID(categoryId), HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Void> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
        try {
            category.setId(categoryId);
            categoryService.updateCategory(category);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
