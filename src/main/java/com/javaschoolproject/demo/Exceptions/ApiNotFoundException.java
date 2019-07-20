package com.javaschoolproject.demo.Exceptions;

public class ApiNotFoundException extends Exception {

    public ApiNotFoundException() {
        super("API_KEY Not Found");
    }

}
