package com.commerce.buy.domain;

import java.util.List;

public interface EntityDao<T> {
    T create(EntityDto<T> entityDto);

    T delete(int entityId);
    T update(int entityId);
    List<T> findAll();
}
