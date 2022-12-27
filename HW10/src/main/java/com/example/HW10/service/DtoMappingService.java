package com.example.HW10.service;

import com.example.HW10.dto.ShopWithoutEmployeeQuantityDto;
import com.example.HW10.entity.Shop;

import java.util.List;

public interface DtoMappingService {

    List<ShopWithoutEmployeeQuantityDto> getAllShopsWithoutEmployee();

    ShopWithoutEmployeeQuantityDto convertIntoDto(Shop shop);
}
