package com.example.HW7.Controller;

import com.example.HW7.CRUD.ShopsDBCRUD;
import com.example.HW7.Models.Shop;
import com.example.HW7.ResponseStatusException.ShopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ShopsController {

    private ShopsDBCRUD shopsDBCRUD = new ShopsDBCRUD();

    @RequestMapping(value = "/createshop", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Shop> createShop() {
        Shop shop = new Shop(1L, "Odessa", "Deribasovskaia", "LaCoste", 10, true);
        shopsDBCRUD.addShop(shop);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @GetMapping("/deleteshop/{shopId}")
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

    @GetMapping("/updateshop/{shopId}")
    public Shop updateShop(@PathVariable Long shopId) {
        Shop shop = new Shop(2L, "Kiev", "Chreschiatik", "Gucci", 15, false);
        shopsDBCRUD.updateShop(shopId, shop);
        return shopsDBCRUD.getShopWithID(1L);
    }
}
