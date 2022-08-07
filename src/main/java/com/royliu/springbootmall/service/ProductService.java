package com.royliu.springbootmall.service;

import com.royliu.springbootmall.model.Product;
import com.royliu.springbootmall.viewobject.ProductVO;

public interface ProductService {

    ProductVO getProductById(Integer productId);
}
