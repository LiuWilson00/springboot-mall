package com.royliu.springbootmall.constant;

public enum ProductStatus {
    DEFAULT(1),
    DISABLE(2),
    HIDE(3),
    PREPARING(4);


    public final int label;

    ProductStatus(int i) {
        this.label = 1;
    }

    public static ProductStatus valueOfLabel(int label) {
        for (ProductStatus e : values()) {
            if (e.label == label) {
                return e;
            }
        }
        return null;
    }
}
