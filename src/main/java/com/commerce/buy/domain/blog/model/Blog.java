package com.commerce.buy.domain.blog.model;

import com.commerce.buy.domain.user.model.User;
import jakarta.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(length = 255,updatable = true)
    public String post;

    @ManyToOne()
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public int getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User users) {
        this.user = users;
    }
}
