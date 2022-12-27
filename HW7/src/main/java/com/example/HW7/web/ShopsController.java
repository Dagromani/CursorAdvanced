package com.example.HW7.web;

import com.example.HW7.models.Shop;
import com.example.HW7.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/shops")
public class ShopsController {

    private final ShopService shopService;

    public ShopsController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/createshop")
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        shopService.createShop(shop);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteshop/{shopId}")
    public void deleteShop(@PathVariable Long shopId) {
        shopService.deleteShop(shopId);
    }

    @GetMapping("/getshops")
    public HashMap<Long, Shop> getAll() {
        return shopService.getAllShops();
    }

    @GetMapping("/getshopwithid/{shopId}")
    public Shop getShopWithId(@PathVariable Long shopId) {
        return shopService.findShopWithId(shopId);
    }

    @PutMapping("/updateshop/{shopId}")
    public Shop updateShop(@RequestBody Shop shop, @PathVariable Long shopId) {
        shopService.updateShop(shopId, shop);
        return shopService.findShopWithId(1L);
    }
}
