package com.example.HW7.repository;

import com.example.HW7.models.Shop;

import java.util.HashMap;

public final class ShopsDB {
    private static ShopsDB instance;
    private HashMap<Long, Shop> shopsDB = new HashMap<>();

    private ShopsDB() {
    }

    public static ShopsDB getInstance() {
        if (instance == null) {
            instance = new ShopsDB();
        }

        return instance;
    }

    public HashMap<Long, Shop> getShopsDB() {
        return shopsDB;
    }
}