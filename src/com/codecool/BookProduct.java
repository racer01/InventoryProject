package com.codecool;

public class BookProduct extends Product {
    private int pageSize;

    public BookProduct(String name, Integer price, int pageSize) {
        super(name, price);
        this.pageSize = pageSize;
    }

    public int pageSize() {
        return pageSize;
    }
}
