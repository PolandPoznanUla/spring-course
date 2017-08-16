package com.sda.springcourse.service;

import org.springframework.stereotype.Component;

@Component
public class ReverseService {

private String message;

private boolean lowerCase;

private boolean upperCase;

    public boolean isLowerCase() {
        return lowerCase;
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public String reverse(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}
