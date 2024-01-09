package com.system4.service;

import com.system4.dto.UserDTO;
import com.system4.model.User;
import com.system4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDTO userDTO){
        User user = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getLogin());
        userRepository.save(user);
    }
    public List<UserDTO> getUsers(){
        List<UserDTO> usersDTO = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            usersDTO.add(new UserDTO(user.getName(), user.getSurname(), user.getLogin()));
        }
        return usersDTO;
    }
}
