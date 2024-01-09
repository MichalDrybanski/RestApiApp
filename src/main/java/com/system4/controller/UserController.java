package com.system4.controller;

import com.github.javafaker.Faker;
import com.system4.dto.UserDTO;
import com.system4.factory.FakerUserFactory;
import com.system4.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public void createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }
    @GetMapping("/users")
    public List<UserDTO> getUsers(){
       return userService.getUsers();
    }
}
