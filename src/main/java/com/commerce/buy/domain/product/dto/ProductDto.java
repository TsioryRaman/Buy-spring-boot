package com.commerce.buy.domain.product.dto;

import com.commerce.buy.domain.EntityDto;
import com.commerce.buy.domain.product.model.Product;

import java.util.Date;

public class ProductDto implements EntityDto {
    private String name;

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
        product.setCreated_at(new Date());
        product.setUpdated_at(new Date());
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
    public Object getEntity() {
        return this.product;
    }

    @Override
    public void setEntity(Object object) {
        this.product = (Product) object;
    }
}
