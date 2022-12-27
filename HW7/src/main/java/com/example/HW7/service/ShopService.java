package com.example.HW7.service;

import com.example.HW7.models.Shop;

import java.util.HashMap;

public interface ShopService {

    void createShop(Shop shop);

    void deleteShop(Long id);

    HashMap<Long, Shop> getAllShops();

    Shop findShopWithId(Long id);

    void updateShop(Long id, Shop shop);
}
