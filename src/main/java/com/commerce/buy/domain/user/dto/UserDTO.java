package com.commerce.buy.domain.user.dto;

import com.commerce.buy.domain.user.model.Address;

import javax.validation.constraints.Size;

public class UserDTO {

    @Size(min = 6,max = 255,message = "Le nom d'utilisateur doit avoir une longueur superieur a 4")
    private String username;
    private String description;
    private Address address;

    public Address getAddress(){return this.address;}
    public void setAddress(Address address){this.address = address;}
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
