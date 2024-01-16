package com.commerce.buy.domain.product.dto;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.product.model.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto extends EntityDto<Product> {
    @NotEmpty
    @NotNull
    @Size(min = 4,max = 255)
    private String name;

    @NotEmpty
    @NotNull
    private String description;

    private double price;
    private int liked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }
}
