package com.commerce.buy.domain.user.service;

import com.commerce.buy.domain.user.event.UserCreatedEvent;
import com.commerce.buy.common.exception.entityException.ConflictException;
import com.commerce.buy.common.exception.entityException.NoSuchEntityException;
import com.commerce.buy.infrastructure.repository.UserRepository;
import com.commerce.buy.domain.user.dto.UserDTO;
import com.commerce.buy.domain.user.UserServiceInterface;
import com.commerce.buy.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public ResponseEntity<User> create(UserDTO userDTO) {
        User user = new User();
        System.out.println("userDTO = " + userDTO + " existe t-il? " + this.userRepository.existsByUsername(userDTO.getUsername()));
        if(this.userRepository.existsByUsername(userDTO.getUsername()))
        {
            System.out.println("userDTO = " + userDTO.getUsername()+ " existe deja");
            throw new ConflictException("Le nom d'utilisateur existe deja");
        }
        user.setUsername(userDTO.getUsername());
        user.setDescription(userDTO.getDescription());
        user.setAddress(userDTO.getAddress());
        user = this.userRepository.save(user);
        // Publier la creation d'un utilisateur
        this.applicationEventPublisher.publishEvent(new UserCreatedEvent(user));

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public ResponseEntity<User> update(int id,UserDTO userDTO) throws NoSuchElementException{
        System.out.println(id);
        try{
            User user = this.userRepository.findById(id).get();
            user.setUsername(userDTO.getUsername());
            user.setDescription(userDTO.getDescription());
            user.setAddress(userDTO.getAddress());
            user = this.userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            throw new NoSuchElementException(e);
        }
    }

    @Override
    public ResponseEntity<User> delete(int id) throws NoSuchEntityException {
        User user = this.userRepository.findById(id).get();
        this.userRepository.delete(user);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
