package com.example.HW7.service;

import com.example.HW7.exception.ShopNotFoundException;
import com.example.HW7.repository.ShopsDB;
import com.example.HW7.models.Shop;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ShopService {

    private ShopsDB shopsDB = ShopsDB.getInstance();

    public void addShop(Shop shop) {
        shopsDB.getShopsDB().put(shop.getId(), shop);
    }

    public void removeShopWithID(Long id) {
        shopsDB.getShopsDB().remove(id);
    }

    public HashMap<Long, Shop> getAllShops() {
        return shopsDB.getShopsDB();
    }

    public Shop getShopWithID(Long id) {
        Shop shop = shopsDB.getShopsDB().get(id);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found");
        } else {
            return shop;
        }
    }

    public void updateShop(Long id, Shop shop) {
        shopsDB.getShopsDB().replace(id, new Shop(id, shop.getCity(), shop.getStreet(), shop.getName(), shop.getEmployeeQuantity(), shop.isWebSiteAvailability()));
    }
}
