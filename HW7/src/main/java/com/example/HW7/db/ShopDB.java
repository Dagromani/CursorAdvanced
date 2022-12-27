package com.example.HW7.db;

import com.example.HW7.models.Shop;

import java.util.HashMap;

public final class ShopDB {
    private static ShopDB instance;
    private HashMap<Long, Shop> shopsDB = new HashMap<>();

    private ShopDB() {
    }

    public static ShopDB getInstance() {
        if (instance == null) {
            instance = new ShopDB();
        }

        return instance;
    }

    public HashMap<Long, Shop> getShopsDB() {
        return shopsDB;
    }
}
