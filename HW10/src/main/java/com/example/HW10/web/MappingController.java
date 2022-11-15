package com.example.HW10.web;

import com.example.HW10.dto.EmployeeQuantityDto;
import com.example.HW10.service.MappingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MappingController {

    private MappingService mappingService;

    public MappingController(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @GetMapping("/map")
    @ResponseBody
    public List<EmployeeQuantityDto> getAllShopsWithoutEmployee() {
        List<EmployeeQuantityDto> employeeQuantityDto = mappingService.getAllShopsWithoutEmployee();
        return employeeQuantityDto;
    }
}
