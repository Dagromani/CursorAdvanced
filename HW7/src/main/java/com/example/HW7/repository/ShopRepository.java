package com.example.HW7.repository;

import com.example.HW7.exception.ShopNotFoundException;
import com.example.HW7.db.ShopDB;
import com.example.HW7.models.Shop;

import java.util.HashMap;

public class ShopRepository {

    private ShopDB shopDB = ShopDB.getInstance();

    public void save(Shop shop) {
        shopDB.getShopsDB().put(shop.getId(), shop);
    }

    public void delete(Long id) {
        shopDB.getShopsDB().remove(id);
    }

    public HashMap<Long, Shop> getAll() {
        return shopDB.getShopsDB();
    }

    public Shop findById(Long id) {
        Shop shop = shopDB.getShopsDB().get(id);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found");
        } else {
            return shop;
        }
    }

    public void updateShop(Long id, Shop shop) {
        shopDB.getShopsDB().replace(id, new Shop(id, shop.getCity(), shop.getStreet(), shop.getName(), shop.getEmployeeQuantity(), shop.isWebSiteAvailability()));
    }
}
