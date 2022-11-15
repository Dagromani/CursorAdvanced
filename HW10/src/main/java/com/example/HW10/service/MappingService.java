package com.example.HW10.service;

import com.example.HW10.dto.EmployeeQuantityDto;
import com.example.HW10.entity.Shop;

import java.util.List;

public interface MappingService {

    List<EmployeeQuantityDto> getAllShopsWithoutEmployee();

    EmployeeQuantityDto convertIntoDto(Shop shop);
}
