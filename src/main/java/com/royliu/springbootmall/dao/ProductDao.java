package com.royliu.springbootmall.dao;

import com.royliu.springbootmall.dto.ProductQueryParams;
import com.royliu.springbootmall.dto.ProductRequest;
import com.royliu.springbootmall.model.Category;
import com.royliu.springbootmall.model.Product;
import com.royliu.springbootmall.viewobject.ProductVO;

import java.util.List;

public interface ProductDao {

    List<ProductVO> getProducts(ProductQueryParams productQueryParams);
    ProductVO getProductById(Integer productId);
    ProductVO getProductByIdNoFilterStatus(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
