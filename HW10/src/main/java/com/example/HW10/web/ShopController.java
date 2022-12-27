package com.example.HW10.web;

import com.example.HW10.mapper.ObjectMapper;
import com.example.HW10.mapper.impl.ObjectMapperImpl;
import com.example.HW10.service.ShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;
    private final ObjectMapper objectMapper = new ObjectMapperImpl();


    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/addshop")
    public void addShop(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        String shopJson = reader.lines().collect(Collectors.joining());
        shopService.addShop(objectMapper.fromJsonToShop(shopJson));
    }

    @GetMapping("/getshops")
    public void getShops(HttpServletResponse response) throws IOException {
        response.getWriter().write(objectMapper.fromShopListToJson(shopService.getShops()));
    }
}
