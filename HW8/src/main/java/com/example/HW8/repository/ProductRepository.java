package com.example.HW8.repository;

import com.example.HW8.models.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findProductsByExpirationDateLessThan(Date currentDate);

    List<Product> findProductsByPriceLessThan(float price);
}
