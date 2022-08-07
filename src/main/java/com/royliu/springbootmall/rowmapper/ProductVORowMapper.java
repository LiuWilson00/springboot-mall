package com.royliu.springbootmall.rowmapper;

import com.royliu.springbootmall.constant.ProductStatus;
import com.royliu.springbootmall.model.Product;
import com.royliu.springbootmall.viewobject.ProductVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductVORowMapper implements RowMapper<ProductVO> {

    @Override
    public ProductVO mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductVO productVO = new ProductVO();

        productVO.setProductId(resultSet.getInt("product_id"));
        productVO.setProductName(resultSet.getString("product_name"));
        productVO.setCategoryId(resultSet.getInt("category_id"));
        productVO.setImageUrl(resultSet.getString("image_url"));
        productVO.setPrice(resultSet.getInt("price"));
        productVO.setStock(resultSet.getInt("stock"));
        productVO.setDescription(resultSet.getString("description"));
        productVO.setCreatedDate(resultSet.getTimestamp("created_date"));
        productVO.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        productVO.setStatus(resultSet.getInt("status"));
        productVO.setCategoryName(resultSet.getString("category_name"));

        return productVO;
    }

}
