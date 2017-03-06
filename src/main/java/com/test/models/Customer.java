package com.test.models;

/**
 * Created by Owner on 3/1/2017.
 */
public class Customer {
    private  String customerId;
    private String companyName;
    private String city;
    private String country;

    public Customer(String customerId, String companyName, String city, String country) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.city = city;
        this.country = country;
    }

    public Customer()
    {
        this("","","","");//empty constructor
        //customerId = "";
        //companyName ="";
        //city="";
        //country="";
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
