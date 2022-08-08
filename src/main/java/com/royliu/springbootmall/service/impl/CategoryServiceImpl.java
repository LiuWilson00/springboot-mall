package com.royliu.springbootmall.service.impl;

import com.royliu.springbootmall.dao.CategoryDao;
import com.royliu.springbootmall.model.Category;
import com.royliu.springbootmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryDao.getCategoryById(categoryId);
    }
}
