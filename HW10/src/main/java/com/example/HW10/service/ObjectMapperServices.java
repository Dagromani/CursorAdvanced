package com.example.HW10.service;

import com.example.HW10.entity.Shop;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ObjectMapperServices {
    Shop fromJsonToShop(String json) throws JsonProcessingException;

    String fromShopListToJson(List<Shop> shopList) throws JsonProcessingException;

}
