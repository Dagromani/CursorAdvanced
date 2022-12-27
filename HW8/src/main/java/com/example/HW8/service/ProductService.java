package com.example.HW8.service;

import com.example.HW8.models.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product update(Product product);

    void delete(Long id);

    List<Product> showAll();

    Product findById(Long id);

    List<Product> findExpiredProducts();

    List<Product> findProductsCheaperThan50();

    List<Product> getProductsByOptionalExpirationDuration(long years);


}
