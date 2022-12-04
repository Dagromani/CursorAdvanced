package com.example.HW11.service.impl;

import com.example.HW11.models.Product;
import com.example.HW11.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepositoryMock;
    @InjectMocks
    private ProductServiceImpl productServiceMock;

    @Test
    void create() {
        Product product = new Product("name", 50, "description", "country", new Date(2022 - 12 - 01), new Date(2022 - 12 - 01));
        given(productRepositoryMock.save(product)).willReturn(product);
        assertEquals(product, productServiceMock.create(product));
    }

    @Test
    void update() {
        Product product = new Product(3L, "name", 50, "description", "country", new Date(2022 - 12 - 01), new Date(2022 - 12 - 01));
        given(productRepositoryMock.save(product)).willReturn(product);
        assertEquals(product, productServiceMock.update(product));
    }

    @Test
    void showAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        productList.add(new Product(3L, "Cola", 5.5F, "so much sugar", "America", new Date(2015 - 10 - 02), new Date(2016 - 10 - 02)));
        given(productRepositoryMock.findAll()).willReturn(productList);
        assertEquals(productList, productServiceMock.showAll());
    }

    @Test
    void findById() {
        Product product = new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02));
        given(productRepositoryMock.findById(2L)).willReturn(Optional.of(product));
        assertEquals(Optional.of(product), productServiceMock.findById(2L));
    }

    @Test
    void findExpiredProducts() {
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        expectedProductList.add(new Product(3L, "Cola", 5.5F, "so much sugar", "America", new Date(2015 - 10 - 02), new Date(2016 - 10 - 02)));
        List<Product> actualProductList = new ArrayList<>();
        java.util.Date currentDate = new java.util.Date();
        given(productRepositoryMock.findAll()).willReturn(expectedProductList);
        for (int i = 0; i < productServiceMock.showAll().size(); i++) {
            if (currentDate.compareTo(productServiceMock.showAll().get(i).getExpirationDate()) > 0) {
                actualProductList.add(productServiceMock.showAll().get(i));
            }
        }
        assertEquals(expectedProductList, actualProductList);
//        given(productRepositoryMock.findProductsByExpirationDateLessThan(currentDate)).willReturn(productList);
//        assertEquals(productList , productServiceMock.findExpiredProducts());
    }

    @Test
    void findProductsCheaperThan50() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        productList.add(new Product(3L, "Cola", 5.5F, "so much sugar", "America", new Date(2015 - 10 - 02), new Date(2016 - 10 - 02)));
        given(productRepositoryMock.findProductsByPriceLessThan(50L)).willReturn(productList);
        assertEquals(productList, productServiceMock.findProductsCheaperThan50());
    }

    @Test
    void getProductsByOptionalExpirationDuration() {
        List<Product> expectedProductList = new ArrayList<>();
        expectedProductList.add(new Product(2L, "Chips", 10.5F, "very fat", "Ukraine", new Date(2010 - 10 - 03), new Date(2012 - 10 - 02)));
        List<Product> actualProductList = new ArrayList<>();
        given(productRepositoryMock.findAll()).willReturn(expectedProductList);
        for (int i = 0; i < productServiceMock.showAll().size(); i++) {
            if (Duration.between(productServiceMock.showAll().get(i).getYearWhenProduced().toInstant(), productServiceMock.showAll().get(i).getExpirationDate().toInstant()).toDays() == 0) {
                actualProductList.add(productServiceMock.showAll().get(i));
            }
        }
        assertEquals(expectedProductList, actualProductList);
//        given(productServiceMock.getProductsByOptionalExpirationDuration(2L)).willReturn(productList);
//        assertEquals(productList , productServiceMock.getProductsByOptionalExpirationDuration(2L));
    }
}