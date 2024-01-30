package com.commerce.buy.common.exception.handler;

import com.commerce.buy.common.error.ApiError;
import com.commerce.buy.common.exception.entityException.ConflictException;
import com.commerce.buy.common.exception.entityException.NoSuchEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler {
    @ExceptionHandler({NoSuchEntityException.class})
    public ResponseEntity<Object> noSuchEntityExist(NoSuchEntityException noSuchEntityException)
    {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(HttpStatus.NOT_FOUND,noSuchEntityException.getMessage()));
    }

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<Object> entityCreateConflict(ConflictException exception)
    {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(HttpStatus.CONFLICT,exception.getMessage()));
    }
}
