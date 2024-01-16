package com.commerce.buy.http.service;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.infrastructure.search.dto.RequestDto;
import com.commerce.buy.infrastructure.search.dto.SearchRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CrudServiceInterface<T> {
    ResponseEntity<T> create(EntityDto<T> entityDto);
    ResponseEntity<T> update(int id,EntityDto<T> entityDto);
    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> getById(int id);

    T findByName(String name);
}
