package com.commerce.buy.infrastructure.exception.entityException;

import jakarta.persistence.EntityNotFoundException;

public class NoSuchEntityException extends EntityNotFoundException {
    public NoSuchEntityException(String message){
        super(message);
    }
}
