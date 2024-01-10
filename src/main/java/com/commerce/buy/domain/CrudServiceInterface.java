package com.commerce.buy.domain;

import com.commerce.buy.infrastructure.search.dto.RequestDto;
import com.commerce.buy.infrastructure.search.dto.SearchRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudServiceInterface<T> {
    ResponseEntity<T> create(EntityDto entityDto) throws Exception;
    ResponseEntity<List<T>> getAll();

    ResponseEntity<T> getById(int id);

    T findByName(String name);

    List<T> findByName(SearchRequestDto searchRequestDto);

    List<T> findByMultipleName(List<RequestDto> requestDtos);
}
