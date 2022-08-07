package com.royliu.springbootmall.service.impl;

import com.royliu.springbootmall.dao.ProductDao;
import com.royliu.springbootmall.service.ProductService;
import com.royliu.springbootmall.viewobject.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;

    @Override
    public ProductVO getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
