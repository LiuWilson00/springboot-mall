package com.royliu.springbootmall.dto;

import com.royliu.springbootmall.constant.ProductStatus;

public class ProductQueryParams {

    private Integer categoryId;
    private String search;

    public ProductQueryParams(Integer category_id, String search, Integer status) {
        this.categoryId = category_id;
        this.search = search;
        if (status != null) {
            this.status = ProductStatus.valueOfLabel(status);
        }
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    private ProductStatus status;


}
