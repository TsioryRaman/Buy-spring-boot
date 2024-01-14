package com.commerce.buy.domain.user;

import com.commerce.buy.domain.user.dto.UserDTO;
import com.commerce.buy.domain.user.model.User;
import com.commerce.buy.infrastructure.exception.entityException.NoSuchEntityException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInterface {
    public ResponseEntity<User> create(UserDTO userDTO);

    List<User> getAllUsers();

    ResponseEntity<User> update(int id,UserDTO userDTO) throws NoSuchEntityException;

    ResponseEntity<User> delete(int id) throws NoSuchEntityException;
}
