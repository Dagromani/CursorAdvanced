package com.example.HW7.controller;

import com.example.HW7.service.ShopService;
import com.example.HW7.models.Shop;
import com.example.HW7.exception.ShopNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ShopsController {

    private final ShopService shopService;

    public ShopsController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/createshop")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteshop/{shopId}")
    public void deleteShop(@PathVariable Long shopId) {
        shopService.removeShopWithID(shopId);
    }

    @GetMapping("/getshops")
    public HashMap<Long, Shop> getAll() {
        return shopService.getAllShops();
    }

    @GetMapping("/getshopwithid/{shopId}")
    public Shop getShopWithId(@PathVariable Long shopId) {
        return shopService.getShopWithID(shopId);
    }

    @PutMapping("/updateshop/{shopId}")
    public Shop updateShop(@RequestBody Shop shop, @PathVariable Long shopId) {
        shopService.updateShop(shopId, shop);
        return shopService.getShopWithID(1L);
    }
}
