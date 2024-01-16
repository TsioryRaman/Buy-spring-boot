package com.commerce.buy.domain.product.model;

import com.commerce.buy.domain.category.model.Category;
import com.commerce.buy.domain.model.EntityDateTimeStamp;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class Product extends EntityDateTimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 255,nullable = false,unique = true)
    private String name;
    @Column(length = 255,nullable = true)
    private String description;
    private double price;
    private int liked;
    @ManyToOne()
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }
}
