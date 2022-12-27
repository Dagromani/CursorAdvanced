package com.example.HW10.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    private String name;
    private Long employeeQuantity;
    private boolean websiteExistence;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(Long employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public boolean isWebsiteExistence() {
        return websiteExistence;
    }

    public void setWebsiteExistence(boolean websiteExistence) {
        this.websiteExistence = websiteExistence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", employeeQuantity=" + employeeQuantity +
                ", websiteExistence=" + websiteExistence +
                '}';
    }
}
