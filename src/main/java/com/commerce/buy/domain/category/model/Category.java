package com.commerce.buy.domain.category.model;

import com.commerce.buy.domain.model.EntityDateTimeStamp;
import com.commerce.buy.domain.product.model.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Set;

import java.util.Date;

@Entity
public class Category extends EntityDateTimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    private String name;
    @OneToMany
    Set<Product> product;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
