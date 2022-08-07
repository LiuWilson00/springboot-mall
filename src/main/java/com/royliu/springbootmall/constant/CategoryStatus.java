package com.royliu.springbootmall.constant;

public enum CategoryStatus {
    DEFAULT(1),
    DISABLE(2);


    public final int label;

    CategoryStatus(int i) {
        this.label = 1;
    }
    public static CategoryStatus valueOfLabel(int label) {
        for (CategoryStatus e : values()) {
            if (e.label == label) {
                return e;
            }
        }
        return null;
    }
}
