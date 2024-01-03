package com.commerce.buy.domain.user;

import com.commerce.buy.domain.DomainServiceInterface;
import com.commerce.buy.domain.user.dto.UserDTO;
import com.commerce.buy.domain.user.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterface extends DomainServiceInterface {
    public ResponseEntity<User> create(UserDTO userDTO);

    List<User> getAllUsers();

    ResponseEntity<User> update(int id,UserDTO userDTO);
}
