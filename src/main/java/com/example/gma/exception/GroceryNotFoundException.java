package com.example.gma.exception;

public class GroceryNotFoundException extends RuntimeException {

    private final String message;
    private final String redirectTo;

    public GroceryNotFoundException(String message, String redirectTo) {
        this.message = message;
        this.redirectTo = redirectTo;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getRedirectTo() {
        return redirectTo;
    }
}
