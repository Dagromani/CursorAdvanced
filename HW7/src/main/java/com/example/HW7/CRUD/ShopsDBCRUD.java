package com.example.HW7.CRUD;

import com.example.HW7.DB.ShopsDB;
import com.example.HW7.Models.Shop;

import java.util.HashMap;

public class ShopsDBCRUD {

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
        return shopsDB.getShopsDB().get(id);
    }

    public void updateShop(Long id, Shop shop) {
        shopsDB.getShopsDB().replace(id, new Shop(id, shop.getCity(), shop.getStreet(), shop.getName(), shop.getEmployeeQuantity(), shop.isWebSiteAvailability()));
    }
}
