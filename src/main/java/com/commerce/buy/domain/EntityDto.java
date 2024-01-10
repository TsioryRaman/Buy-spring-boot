package com.commerce.buy.domain;

import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;

public interface EntityDto {
    void hydrate();

    Object getEntity();

    void setEntity(Object object);
}
