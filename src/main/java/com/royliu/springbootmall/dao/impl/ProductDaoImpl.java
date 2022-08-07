package com.royliu.springbootmall.dao.impl;

import com.royliu.springbootmall.dao.ProductDao;
import com.royliu.springbootmall.rowmapper.ProductVORowMapper;
import com.royliu.springbootmall.viewobject.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

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
}
