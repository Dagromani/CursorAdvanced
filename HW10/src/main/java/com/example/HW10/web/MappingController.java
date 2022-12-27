package com.example.HW10.web;

import com.example.HW10.dto.ShopWithoutEmployeeQuantityDto;
import com.example.HW10.service.DtoMappingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MappingController {

    private DtoMappingService dtoMappingService;

    public MappingController(DtoMappingService dtoMappingService) {
        this.dtoMappingService = dtoMappingService;
    }

    @GetMapping("/map")
    @ResponseBody
    public List<ShopWithoutEmployeeQuantityDto> getAllShopsWithoutEmployee() {
        List<ShopWithoutEmployeeQuantityDto> shopWithoutEmployeeQuantityDto = dtoMappingService.getAllShopsWithoutEmployee();
        return shopWithoutEmployeeQuantityDto;
    }
}
