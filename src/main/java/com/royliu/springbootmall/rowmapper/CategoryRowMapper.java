package com.royliu.springbootmall.rowmapper;

import com.royliu.springbootmall.constant.CategoryStatus;
import com.royliu.springbootmall.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {


    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();

        category.setCategoryId(resultSet.getInt("category_id"));
        category.setCategoryName(resultSet.getString("category_name"));
        category.setSubtitle(resultSet.getString("subtitle"));
        category.setImageUrl(resultSet.getString("image_url"));
        category.setStatus(CategoryStatus.valueOfLabel(resultSet.getInt("status")));
        category.setCreatedDate(resultSet.getDate("created_date"));
        category.setLastModifiedDate(resultSet.getDate("last_modified_date"));

        return category;
    }
}
