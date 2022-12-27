package com.example.HW10.service.impl;

import com.example.HW10.dto.ShopWithoutEmployeeQuantityDto;
import com.example.HW10.entity.Shop;
import com.example.HW10.repository.ShopRepository;
import com.example.HW10.service.DtoMappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtoMappingServiceImpl implements DtoMappingService {

    private final ShopRepository shopRepository;

    public DtoMappingServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopWithoutEmployeeQuantityDto> getAllShopsWithoutEmployee() {
        return shopRepository.findAll().stream().map(this::convertIntoDto).collect(Collectors.toList());
    }

    public ShopWithoutEmployeeQuantityDto convertIntoDto(Shop shop) {
        ShopWithoutEmployeeQuantityDto shopWithoutEmployeeQuantityDto = new ShopWithoutEmployeeQuantityDto();
        shopWithoutEmployeeQuantityDto.setId(shop.getId());
        shopWithoutEmployeeQuantityDto.setCity(shop.getCity());
        shopWithoutEmployeeQuantityDto.setCountry(shop.getCountry());
        shopWithoutEmployeeQuantityDto.setName(shop.getName());
        shopWithoutEmployeeQuantityDto.isWebsiteExistence();
        return shopWithoutEmployeeQuantityDto;
    }
}
