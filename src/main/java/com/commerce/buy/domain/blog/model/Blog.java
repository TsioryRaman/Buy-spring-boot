package com.commerce.buy.domain.blog.model;

import jakarta.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(length = 255,updatable = true)
    public String post;
}
