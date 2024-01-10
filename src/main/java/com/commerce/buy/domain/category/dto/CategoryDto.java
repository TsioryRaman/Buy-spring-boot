package com.commerce.buy.domain.category.dto;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.category.model.Category;

import java.util.Date;

public class CategoryDto implements EntityDto<Category> {
    private String name;
    private Category category;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void hydrate() {
        this.category.setName(this.name);
        this.category.setUpdated_at(new Date());
        this.category.setCreated_at(new Date());
    }

    @Override
    public Category getEntity() {
        return this.category;
    }

    @Override
    public void setEntity(Category entity) {
        this.category = entity;
    }
}
