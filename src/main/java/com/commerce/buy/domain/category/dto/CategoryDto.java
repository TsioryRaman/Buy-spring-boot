package com.commerce.buy.domain.category.dto;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.category.model.Category;

public class CategoryDto extends EntityDto<Category> {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
