package com.royliu.springbootmall.dao;

import com.royliu.springbootmall.model.Product;
import com.royliu.springbootmall.viewobject.ProductVO;

public interface ProductDao {

    ProductVO getProductById(Integer productId);
}
