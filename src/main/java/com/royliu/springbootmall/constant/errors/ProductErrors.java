package com.royliu.springbootmall.constant.errors;

public enum ProductErrors {

    CATEGORY_NOT_EXIST("搜尋的分類不存在");


    public final String msg;

    ProductErrors(String text) {
        this.msg = text;
    }
}
