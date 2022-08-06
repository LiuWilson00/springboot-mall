package com.royliu.springbootmall.dao;

import com.royliu.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
