package com.example.HW10.dto;

public class EmployeeQuantityDto {

    private Long id;
    private String country;
    private String city;
    private String name;
    private boolean websiteExistence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isWebsiteExistence() {
        return this.websiteExistence;
    }

    public void setWebsiteExistence(boolean websiteExistence) {
        this.websiteExistence = websiteExistence;
    }

    @Override
    public String toString() {
        return "EmployeeQuantityDto{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", websiteExistence=" + websiteExistence +
                '}';
    }
}
