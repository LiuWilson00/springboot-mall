package com.royliu.springbootmall.dao.impl;

import com.royliu.springbootmall.dao.CategoryDao;
import com.royliu.springbootmall.model.Category;
import com.royliu.springbootmall.rowmapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Category> getCategories() {
        String sql = "SELECT category_id,category_name,subtitle,image_url,status," +
                "created_date,last_modified_date FROM category";
        Map<String, Object> map = new HashMap<>();
        List<Category> categories = namedParameterJdbcTemplate.query(sql, map, new CategoryRowMapper());
        System.out.println("category1 id: " + categories.get(0).getCategoryId());
        System.out.println("category1 name: " + categories.get(0).getCategoryName());
        System.out.println("category1 status: " + categories.get(0).getStatus());
        System.out.println("category1 image url: " + categories.get(0).getImageUrl());
        System.out.println("category id: " + categories.get(1).getCategoryId());
        return categories;
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        String sql = "SELECT category_id,category_name,subtitle,image_url,status," +
                "created_date,last_modified_date FROM category WHERE category_id = :categoryId";
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        List<Category> categories = namedParameterJdbcTemplate.query(sql, map, new CategoryRowMapper());
        if (categories.size() != 0) {
            return categories.get(0);
        } else {
            return null;
        }
    }
}
