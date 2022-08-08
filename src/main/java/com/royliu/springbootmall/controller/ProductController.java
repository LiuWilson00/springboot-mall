package com.royliu.springbootmall.controller;

import com.royliu.springbootmall.constant.errors.ProductErrors;
import com.royliu.springbootmall.dto.ProductQueryParams;
import com.royliu.springbootmall.dto.ProductRequest;
import com.royliu.springbootmall.model.Category;
import com.royliu.springbootmall.model.Product;
import com.royliu.springbootmall.service.CategoryService;
import com.royliu.springbootmall.service.ProductService;
import com.royliu.springbootmall.viewobject.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/products")
    public ResponseEntity<List<ProductVO>> getProducts(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer status
    ) {
        ProductQueryParams productQueryParams = new ProductQueryParams(categoryId, search, status);

        List<ProductVO> products = productService.getProducts(productQueryParams);


        return ResponseEntity.status(HttpStatus.OK).body(products);
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductVO> getProduct(@PathVariable Integer productId) {

        ProductVO product = productService.getProductById(productId);


        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        ResponseEntity checkCategory = checkCategoryExist(productRequest.getCategoryId());
        if (checkCategory != null) {
            return checkCategory;
        }

        int newProductId = productService.createProduct(productRequest);
        ProductVO newProduct = productService.getProductByIdNoFilterStatus(newProductId);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer productId, @RequestBody ProductRequest productRequest) {
        ResponseEntity checkCategory = checkCategoryExist(productRequest.getCategoryId());
        if (checkCategory != null) {
            return checkCategory;
        }

        ProductVO product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productService.updateProduct(productId, productRequest);
        ProductVO updateProduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    private ResponseEntity<?> checkCategoryExist(Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ProductErrors.CATEGORY_NOT_EXIST.msg);
        }

        return null;
    }

}
