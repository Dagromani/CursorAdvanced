package com.example.HW11.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float price;
    private String description;
    private String countryProducer;
    private Date yearWhenProduced;
    private Date expirationDate;

    public Product() {
    }

    public Product(String name, float price, String description, String countryProducer, Date yearWhenProduced, Date expirationDate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.countryProducer = countryProducer;
        this.yearWhenProduced = yearWhenProduced;
        this.expirationDate = expirationDate;
    }

    public Product(Long id, String name, float price, String description, String countryProducer, Date yearWhenProduced, Date expirationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.countryProducer = countryProducer;
        this.yearWhenProduced = yearWhenProduced;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", countryProducer='" + countryProducer + '\'' +
                ", yearWhenProduced=" + yearWhenProduced +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
