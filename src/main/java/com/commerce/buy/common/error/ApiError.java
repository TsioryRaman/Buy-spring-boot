package com.commerce.buy.common.error;

import org.springframework.http.HttpStatus;

public class ApiError {
    public HttpStatus status;
    public String message;

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
