package com.codecool;

public class CDProduct extends Product {
    private int numOfTracks;

    public CDProduct(String name, Integer price, int numOfTracks) {
        super(name, price);
        this.numOfTracks = numOfTracks;
    }

    public int numOfTracks() {
        return numOfTracks;
    }
}
