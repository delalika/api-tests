package com.rest.models;

public class Auth {

    public String getName() {
        return "X-Api-Key";
    }

    //Instead of empty String provide your postman api key
    public String getValue() {
        return "";
    }
}
