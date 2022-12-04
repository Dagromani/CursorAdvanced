package com.example.HW11.service;

import com.example.HW11.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);

    Product update(Product product);

    void delete(Long id);

    List<Product> showAll();

    Optional<Product> findById(Long id);

    List<Product> findExpiredProducts();

    List<Product> findProductsCheaperThan50();

    List<Product> getProductsByOptionalExpirationDuration(long years);


}
