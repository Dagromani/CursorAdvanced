package com.example.HW7.controller;

import com.example.HW7.cRUD.ShopsDBCRUD;
import com.example.HW7.models.Shop;
import com.example.HW7.responseStatusException.ShopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ShopsController {

    private ShopsDBCRUD shopsDBCRUD = new ShopsDBCRUD();

    @PostMapping(value = "/createshop")
    public ResponseEntity<Shop> createShop() {
        Shop shop = new Shop(1L, "Odessa", "Deribasovskaia", "LaCoste", 10, true);
        shopsDBCRUD.addShop(shop);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteshop/{shopId}")
    public void deleteShop(@PathVariable Long shopId) {
        shopsDBCRUD.removeShopWithID(shopId);
    }

    @GetMapping("/getshops")
    public HashMap<Long, Shop> getAll() {
        return shopsDBCRUD.getAllShops();
    }

    @GetMapping("/getshopwithid/{shopId}")
    public Shop getShopWithId(@PathVariable Long shopId) throws ShopNotFoundException {
        Shop shop = shopsDBCRUD.getShopWithID(shopId);
        if (shop == null) {
            throw new ShopNotFoundException("Shop not found");
        } else {
            return shop;
        }
    }

    @PutMapping("/updateshop/{shopId}")
    public Shop updateShop(@PathVariable Long shopId) {
        Shop shop = new Shop(2L, "Kiev", "Chreschiatik", "Gucci", 15, false);
        shopsDBCRUD.updateShop(shopId, shop);
        return shopsDBCRUD.getShopWithID(1L);
    }
}
