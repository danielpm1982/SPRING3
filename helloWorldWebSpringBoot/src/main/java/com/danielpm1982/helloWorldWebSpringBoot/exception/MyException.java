package com.danielpm1982.helloWorldWebSpringBoot.exception;

public class MyException extends Exception {
    private final String message;
    public MyException(String message) {
        super(message);
        this.message=message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
