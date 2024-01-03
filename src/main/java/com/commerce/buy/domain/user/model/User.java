package com.commerce.buy.domain.user.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = true)
    private String description;

    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Address address;

    public Address getAddress()
    {
        return this.address;
    }

    public void setAddress(Address address)
    {
        this.address =address;
    }
    public int getId()
    {
        return this.id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
