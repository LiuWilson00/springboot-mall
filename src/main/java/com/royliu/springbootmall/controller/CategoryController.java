package com.royliu.springbootmall.controller;

import com.royliu.springbootmall.model.Category;
import com.royliu.springbootmall.service.CategoryService;
import com.royliu.springbootmall.viewobject.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategories() {

        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer categoryId) {

        Category category = categoryService.getCategoryById(categoryId);


        if (category != null) {
            return ResponseEntity.status(HttpStatus.OK).body(category);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
