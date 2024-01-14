package com.commerce.buy.infrastructure.exception.entityException;

public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}
