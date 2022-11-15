package com.example.HW10.service.impl;

import com.example.HW10.dto.EmployeeQuantityDto;
import com.example.HW10.entity.Shop;
import com.example.HW10.repository.ShopRepository;
import com.example.HW10.service.MappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingServiceImpl implements MappingService {

    private final ShopRepository shopRepository;

    public MappingServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<EmployeeQuantityDto> getAllShopsWithoutEmployee() {
        return shopRepository.findAll().stream().map(this::convertIntoDto).collect(Collectors.toList());
    }

    public EmployeeQuantityDto convertIntoDto(Shop shop) {
        EmployeeQuantityDto employeeQuantityDto = new EmployeeQuantityDto();
        employeeQuantityDto.setId(shop.getId());
        employeeQuantityDto.setCity(shop.getCity());
        employeeQuantityDto.setCountry(shop.getCountry());
        employeeQuantityDto.setName(shop.getName());
        employeeQuantityDto.isWebsiteExistence();
        return employeeQuantityDto;
    }
}
