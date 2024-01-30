package com.commerce.buy.common.exception.entityException;

import jakarta.persistence.EntityNotFoundException;

public class NoSuchEntityException extends EntityNotFoundException {
    public NoSuchEntityException(String message){
        super(message);
    }
}
