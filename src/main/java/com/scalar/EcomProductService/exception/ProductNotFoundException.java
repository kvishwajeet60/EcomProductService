package com.scalar.EcomProductService.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String s) {
        super(s);
    }

    public ProductNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
