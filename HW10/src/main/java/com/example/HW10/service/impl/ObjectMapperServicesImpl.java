package com.example.HW10.service.impl;

import com.example.HW10.entity.Shop;
import com.example.HW10.service.ObjectMapperServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ObjectMapperServicesImpl implements ObjectMapperServices {

    @Override
    public Shop fromJsonToShop(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = objectMapper.readValue(json, Shop.class);
        return shop;
    }

    @Override
    public String fromShopListToJson(List<Shop> shopList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String shopsJson = objectMapper.writeValueAsString(shopList);
        return shopsJson;
    }
}
