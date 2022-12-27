package com.example.HW10.service.impl;

import com.example.HW10.entity.Shop;
import com.example.HW10.repository.ShopRepository;
import com.example.HW10.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }


    @Override
    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public List<Shop> getShops() {
        return shopRepository.findAll();
    }
}
