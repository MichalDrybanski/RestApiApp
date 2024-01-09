package com.system4.service;

import com.system4.dto.UserDTO;
import com.system4.dto.UsersDTO;
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

    public void createUsers(UsersDTO usersDTO){
        List<User> users = new ArrayList<>();
        List<UserDTO> userDTOS = usersDTO.getUsers();
        for(UserDTO userDTO : userDTOS){
            users.add(new User(userDTO.getName(), userDTO.getSurname(), userDTO.getLogin()));
        }
        userRepository.saveAll(users);
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
