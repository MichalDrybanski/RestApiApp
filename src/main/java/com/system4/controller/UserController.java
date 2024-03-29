package com.system4.controller;

import com.system4.dto.UserDTO;
import com.system4.dto.UsersDTO;
import com.system4.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public Page<UserDTO> getUsers(@RequestParam(defaultValue = "") String searchTerm,
                               @PageableDefault(size = 100, sort = "name") Pageable pageable) {
        return userService.getUsers(searchTerm, pageable);
    }
    @PostMapping("/users")
    public void createUsers(@RequestBody UsersDTO usersDTO){
        userService.createUsers(usersDTO);
    }
}

