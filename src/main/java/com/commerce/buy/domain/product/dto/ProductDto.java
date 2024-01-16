package com.commerce.buy.domain.product.dto;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.product.model.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ProductDto implements EntityDto<Product> {
    @NotEmpty
    @NotNull
    @Size(min = 4,max = 255)
    private String name;

    @NotEmpty
    @NotNull
    private String description;

    private double price;
    private int liked;
    private Product product;

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

    @Override
    public void hydrate() {
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setLiked(this.getLiked());
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

    @Override
    public Product getEntity() {
        return this.product;
    }

    @Override
    public void setEntity(Product entity) {
        this.product = entity;
    }
}
