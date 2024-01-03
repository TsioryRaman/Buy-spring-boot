package com.commerce.buy.domain.user.service;

import com.commerce.buy.infrastructure.validation.repository.UserRepository;
import com.commerce.buy.domain.user.dto.UserDTO;
import com.commerce.buy.domain.user.UserServiceInterface;
import com.commerce.buy.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    public UserRepository userRepository;

    @Override
    public ResponseEntity<User> create(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setDescription(userDTO.getDescription());
        user.setAddress(userDTO.getAddress());
        this.userRepository.save(user);

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public ResponseEntity<User> update(int id,UserDTO userDTO) {
        System.out.println(id);
        try{
            User user = this.userRepository.findById(id).get();
            user.setUsername(userDTO.getUsername());
            user.setDescription(userDTO.getDescription());
            user.setAddress(userDTO.getAddress());
            System.out.println("ici");
            user = this.userRepository.save(user);
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
