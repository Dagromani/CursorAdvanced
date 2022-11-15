package com.example.HW10.service;

import com.example.HW10.entity.Shop;

import java.util.List;

public interface ShopService {

    void addShop(Shop shop);

    List<Shop> getShops();
}
