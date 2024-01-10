package com.commerce.buy.domain;

import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;

public interface EntityDto<T> {
    void hydrate();

    T getEntity();

    void setEntity(T entity);
}
