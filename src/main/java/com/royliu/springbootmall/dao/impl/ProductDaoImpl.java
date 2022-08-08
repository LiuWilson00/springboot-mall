package com.royliu.springbootmall.dao.impl;

import com.royliu.springbootmall.dao.ProductDao;
import com.royliu.springbootmall.dto.ProductRequest;
import com.royliu.springbootmall.rowmapper.ProductVORowMapper;
import com.royliu.springbootmall.viewobject.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ProductVO getProductById(Integer productId) {
        String sql = "SELECT product_id,product_name,p.category_id,p.image_url," +
                "price,description,stock," +
                "category_name,p.status,p.created_date,p.last_modified_date " +
                "FROM product p JOIN category c ON c.category_id = p.category_id " +
                "WHERE product_id=:productId and p.status = 1";
        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<ProductVO> productList = namedParameterJdbcTemplate.query(sql, map, new ProductVORowMapper());


        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product (product_name, category_id ,status, image_url, price, stock, description, created_date, last_modified_date) " +
                "VALUES (:productName, :categoryId,:status, :imageUrl, :price, :stock, :description, :createdDate, :lastModifiedDate);";
        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("categoryId", productRequest.getCategoryId());
        map.put("status", productRequest.getStatus());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();

        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int productId = keyHolder.getKey().intValue();
        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

        String sql = "UPDATE product SET product_name = :productName,category_id = :categoryId,status = :status, " +
                "price = :price, stock = :stock, description = :description , last_modified_date = :lastModifiedDate " +
                "WHERE product_id = :productId ";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("categoryId", productRequest.getCategoryId());
        map.put("status", productRequest.getStatus());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();

        map.put("lastModifiedDate", now);

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
