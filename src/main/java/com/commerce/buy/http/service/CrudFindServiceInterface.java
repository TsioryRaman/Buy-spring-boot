package com.commerce.buy.http.service;

import com.commerce.buy.infrastructure.search.dto.RequestDto;
import com.commerce.buy.infrastructure.search.dto.SearchRequestDto;

import java.util.List;

public interface CrudFindServiceInterface<T> {
    List<T> findByName(SearchRequestDto searchRequestDto);

    List<T> findByMultipleName(List<RequestDto> requestDtos);
}
