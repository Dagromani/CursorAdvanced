package com.example.HW7.models;

public class Shop {
    private Long id;
    private String city;
    private String street;
    private String name;
    private int employeeQuantity;
    private boolean webSiteAvailability;

    public Shop(Long id, String city, String street, String name, int employeeQuantity, boolean webSiteAvailability) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.name = name;
        this.employeeQuantity = employeeQuantity;
        this.webSiteAvailability = webSiteAvailability;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(int employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public boolean isWebSiteAvailability() {
        return webSiteAvailability;
    }

    public void setWebSiteAvailability(boolean webSiteAvailability) {
        this.webSiteAvailability = webSiteAvailability;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", name='" + name + '\'' +
                ", employeeQuantity=" + employeeQuantity +
                ", webSiteAvailability=" + webSiteAvailability +
                '}';
    }
}
