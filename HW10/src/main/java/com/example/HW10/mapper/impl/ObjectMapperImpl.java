package com.example.HW10.mapper.impl;

import com.example.HW10.entity.Shop;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ObjectMapperImpl implements com.example.HW10.mapper.ObjectMapper {

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
