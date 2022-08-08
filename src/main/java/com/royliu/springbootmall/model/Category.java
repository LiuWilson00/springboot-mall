package com.royliu.springbootmall.model;


import com.royliu.springbootmall.constant.CategoryStatus;

import java.util.Date;

public class Category {

    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    private String categoryName;
    private String subtitle;
    private String imageUrl;
    private Date createdDate;
    private Date lastModifiedDate;

    public Integer getStatus() {
        return status.label;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }

    private CategoryStatus status;
}
