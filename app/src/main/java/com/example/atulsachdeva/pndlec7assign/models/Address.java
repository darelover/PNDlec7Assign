package com.example.atulsachdeva.pndlec7assign.models;

/**
 * Created by AtulSachdeva on 11/09/17.
 */

public class Address {

    String city, zipcode;

    public Address(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
