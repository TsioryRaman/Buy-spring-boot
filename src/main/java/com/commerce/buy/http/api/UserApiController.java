package com.commerce.buy.http.api;

import com.commerce.buy.domain.user.dto.UserDTO;
import com.commerce.buy.domain.user.model.User;
import com.commerce.buy.domain.user.UserServiceInterface;
import com.commerce.buy.common.exception.entityException.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "user")
public class UserApiController {

    @Autowired
    public UserServiceInterface userService;

    @PostMapping(path = "add")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDTO userDTO)
    {
        return this.userService.create(userDTO);
    }

    @GetMapping()
    public List<User> getAllUser()
    {
        return this.userService.getAllUsers();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) throws NoSuchEntityException
    {
        return this.userService.update(id,userDTO);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) throws NoSuchEntityException {
        return this.userService.delete(id);
    }

}
