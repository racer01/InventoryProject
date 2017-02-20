package com.codecool;

public class StoreManager {
    StoreCapable storage;

    public void addStorage(StoreCapable storage) {
        this.storage = storage;
    }

    public void addCDProduct(String name, int price, int size) {
        storage.storeCDProduct(name, price, size);
    }

    public void addBookProduct(String name, int price, int size) {
        storage.storeBookProduct(name, price, size);
    }

    public String listProducts() {
        String productNames = "";
        for (Product product : storage.getAllProduct()) {
            productNames += String.format("%s ", product.name);
        }
        return productNames;
    }

    public int getTotalProductPrice() {
        int totalPrice = 0;
        for (Product product : storage.getAllProduct()) {
            totalPrice += product.price;
        }
        return totalPrice;
    }
}
