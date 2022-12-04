package com.example.HW11.web;

import com.example.HW11.models.Product;
import com.example.HW11.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ProductService productService;

    @Test
    void create() throws Exception {
        Product product = new Product("name", 50, "description", "country", new Date(2022 - 12 - 01), new Date(2022 - 12 - 01));
        String productJson = new ObjectMapper().writeValueAsString(product);
        when(productService.create(product)).thenReturn(product);
        mvc.perform(MockMvcRequestBuilders.post("/products/product").contentType(MediaType.APPLICATION_JSON).content(productJson)).andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        Product product = new Product(3L, "name", 50, "description", "country", new Date(2022 - 12 - 01), new Date(2022 - 12 - 01));
        String productJson = new ObjectMapper().writeValueAsString(product);
        when(productService.update(product)).thenReturn(product);
        RequestBuilder request = MockMvcRequestBuilders.put("/products/changeproduct").contentType(MediaType.APPLICATION_JSON).content(productJson);
        mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    void showAll() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        productList.add(new Product(3L, "Cola", 5.5F, "so much sugar", "America", new Date(2015 - 10 - 02), new Date(2016 - 10 - 02)));
        when(productService.showAll()).thenReturn(productList);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/showproducts")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        List<Product> responseProductList = Arrays.asList(new ObjectMapper().readValue(response, Product[].class));
        assertThat(responseProductList.get(0).getId()).isEqualTo(productList.get(0).getId());
        assertThat(responseProductList.get(1).getId()).isEqualTo(productList.get(1).getId());
    }

    @Test
    void find() throws Exception {
        Product product = new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02));
        when(productService.findById(2L)).thenReturn(Optional.of(product));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/findproduct?id=2")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Product responseProduct = new ObjectMapper().readValue(response, Product.class);
        assertThat(responseProduct.getId()).isEqualTo(product.getId());
    }

    @Test
    void getExpiredProducts() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        productList.add(new Product(3L, "Cola", 5.5F, "so much sugar", "America", new Date(2015 - 10 - 02), new Date(2016 - 10 - 02)));
        when(productService.findExpiredProducts()).thenReturn(productList);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/expiredproducts")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        List<Product> responseProductList = Arrays.asList(new ObjectMapper().readValue(response, Product[].class));
        assertThat(responseProductList.get(0).getId()).isEqualTo(productList.get(0).getId());
        assertThat(responseProductList.get(1).getId()).isEqualTo(productList.get(1).getId());
    }

    @Test
    void getCheapProducts() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        productList.add(new Product(3L, "Cola", 5.5F, "so much sugar", "America", new Date(2015 - 10 - 02), new Date(2016 - 10 - 02)));
        when(productService.findProductsCheaperThan50()).thenReturn(productList);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/cheapproducts")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        List<Product> responseProductList = Arrays.asList(new ObjectMapper().readValue(response, Product[].class));
        assertThat(responseProductList.get(0).getId()).isEqualTo(productList.get(0).getId());
        assertThat(responseProductList.get(1).getId()).isEqualTo(productList.get(1).getId());
    }

    @Test
    void getProductsWithExpirationDuration() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        when(productService.getProductsByOptionalExpirationDuration(2L)).thenReturn((productList));
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products/productswithduration?years=2")).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        List<Product> responseProductList = Arrays.asList(new ObjectMapper().readValue(response, Product[].class));
        assertThat(responseProductList.get(0).getId()).isEqualTo(productList.get(0).getId());
    }
}