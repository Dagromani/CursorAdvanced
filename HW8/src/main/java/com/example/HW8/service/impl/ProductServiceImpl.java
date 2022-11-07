package com.example.HW8.service.impl;

import com.example.HW8.models.Product;
import com.example.HW8.repository.ProductRepository;
import com.example.HW8.service.ProductService;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> showAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findExpiredProducts() {
        java.util.Date currentDate = new java.util.Date();
        return productRepository.findProductsByExpirationDateLessThan(currentDate);
    }

    @Override
    public List<Product> findProductsCheaperThan50() {
        return productRepository.findProductsByPriceLessThan(50);
    }

    @Override
    public List<Product> getProductsByOptionalExpirationDuration(long years) {
        List<Product> suitableProducts = new ArrayList<>();
        for (int i = 0; i < showAll().size(); i++) {
            if (Duration.between(showAll().get(i).getYearWhenProduced().toInstant(), showAll().get(i).getExpirationDate().toInstant()).toDays() == years * 365) {
                suitableProducts.add(showAll().get(i));
            }
        }
        return suitableProducts;
    }
}
