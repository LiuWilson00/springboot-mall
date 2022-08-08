package com.royliu.springbootmall.dao;

import com.royliu.springbootmall.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getCategories();

    Category getCategoryById(Integer categoryId);
}
