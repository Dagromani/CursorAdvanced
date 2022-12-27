package com.example.HW10.mapper;

import com.example.HW10.entity.Shop;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ObjectMapper {
    Shop fromJsonToShop(String json) throws JsonProcessingException;

    String fromShopListToJson(List<Shop> shopList) throws JsonProcessingException;

}
