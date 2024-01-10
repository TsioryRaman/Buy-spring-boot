package com.commerce.buy.domain.user.model;

import com.commerce.buy.domain.blog.model.Blog;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

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
    @JsonIgnore()
    private Address address;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JsonIgnore()
    private Set<Blog> blog;

    public Set<Blog> getBlog() {
        return blog;
    }

    public void addBlog(Blog blog) {
        this.blog.add(blog);
    }

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
