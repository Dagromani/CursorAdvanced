package com.example.HW7.service.impl;

import com.example.HW7.models.Shop;
import com.example.HW7.repository.ShopRepository;
import com.example.HW7.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository = new ShopRepository();

    @Override
    public void createShop(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void deleteShop(Long id) {
        shopRepository.delete(id);
    }

    @Override
    public HashMap<Long, Shop> getAllShops() {
        return shopRepository.getAll();
    }

    @Override
    public Shop findShopWithId(Long id) {
        return shopRepository.findById(id);
    }

    @Override
    public void updateShop(Long id, Shop shop) {
        shopRepository.updateShop(id, shop);
    }

}
