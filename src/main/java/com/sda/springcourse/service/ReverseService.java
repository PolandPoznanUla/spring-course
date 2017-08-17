package com.sda.springcourse.service;

import org.springframework.stereotype.Component;

@Component
public class ReverseService {

    private boolean lowerCase;

    private boolean upperCase;

    public String reverse(String message) {
        return new StringBuilder(message).reverse().toString();
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }
}
