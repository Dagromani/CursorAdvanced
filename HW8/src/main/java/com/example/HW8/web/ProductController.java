package com.example.HW8.web;

import com.example.HW8.models.Product;
import com.example.HW8.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/changeproduct")
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/deleteproduct")
    public void delete(@RequestParam Long id){
        productService.delete(id);
    }

    @GetMapping("/showproducts")
    public List<Product> showAll(){
        return productService.showAll();
    }

    @GetMapping("/findproduct")
    public Optional<Product> find(@RequestParam Long id){
        return productService.findById(id);
    }

    @GetMapping("/expiredproducts")
    public List<Product> getExpiredProducts(){
        return productService.findExpiredProducts();
    }

    @GetMapping("/cheapproducts")
    public List<Product> getCheapProducts(){
        return productService.findProductsCheaperThan50();
    }

    @GetMapping ("/productswithduration")
    List<Product> getProductsWithExpirationDuration(@RequestParam long years){
        return productService.getProductsByOptionalExpirationDuration(years);
    }
}
