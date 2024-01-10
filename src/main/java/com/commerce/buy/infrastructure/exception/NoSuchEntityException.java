package com.commerce.buy.infrastructure.exception;

public class NoSuchEntityException extends Exception{
    public NoSuchEntityException(String message){
        super(message);
    }
}
