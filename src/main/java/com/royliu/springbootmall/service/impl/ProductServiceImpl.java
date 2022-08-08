package com.royliu.springbootmall.service.impl;

import com.royliu.springbootmall.dao.ProductDao;
import com.royliu.springbootmall.dto.ProductQueryParams;
import com.royliu.springbootmall.dto.ProductRequest;
import com.royliu.springbootmall.model.Category;
import com.royliu.springbootmall.service.ProductService;
import com.royliu.springbootmall.viewobject.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductVO> getProducts(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

    @Override
    public ProductVO getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public ProductVO getProductByIdNoFilterStatus(Integer productId) {
        return productDao.getProductByIdNoFilterStatus(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        int newProductId = productDao.createProduct(productRequest);
        return newProductId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
