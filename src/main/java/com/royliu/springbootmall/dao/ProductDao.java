package com.royliu.springbootmall.dao;

import com.royliu.springbootmall.dto.ProductRequest;
import com.royliu.springbootmall.model.Product;
import com.royliu.springbootmall.viewobject.ProductVO;

public interface ProductDao {

    ProductVO getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
