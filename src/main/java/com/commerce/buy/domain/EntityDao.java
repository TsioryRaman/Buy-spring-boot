package com.commerce.buy.domain;

import com.commerce.buy.infrastructure.search.dto.RequestDto;

import java.util.List;

public interface EntityDao<T> {
    T create(EntityDto<T> entityDto);

    T findById(int id);

    T delete(int entityId);
    T update(int entityId);
    List<T> findAll();

    List<T> findByField(List<RequestDto> requestDtos);
}
