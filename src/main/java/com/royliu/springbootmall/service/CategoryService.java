package com.royliu.springbootmall.service;

import com.royliu.springbootmall.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategoryById(Integer categoryId);
}
