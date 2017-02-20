package com.codecool;

public class Main {

    public static void main(String[] args) {
        StoreManager storeManager = new StoreManager();
        StoreCapable store = new PersistentStore();
        storeManager.addStorage(store);
        storeManager.addCDProduct("Daft Punk - Random Access Memories", 3000, 1);

    }
}
