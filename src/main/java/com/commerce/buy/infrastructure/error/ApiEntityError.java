package com.commerce.buy.infrastructure.error;

import org.springframework.http.HttpStatus;

public class ApiEntityError extends ApiError{
    public ApiEntityError(HttpStatus status, String message) {
        super(status, message);
    }
}
