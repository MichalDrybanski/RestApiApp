package com.system4.service;

import com.system4.dto.UserDTO;
import com.system4.dto.UsersDTO;
import com.system4.model.User;
import com.system4.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

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

    public Page<UserDTO> getUsers(String searchTerm, Pageable pageable) {
        return userRepository.findByNameContainingOrSurnameContainingOrLoginContaining(
                searchTerm, searchTerm, searchTerm, pageable)
                .map(user -> new UserDTO(user.getName(), user.getSurname() + "_" +generateMD5(user.getName()), user.getLogin()));
    }
    public String generateMD5(String name) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(name.getBytes());
            byte[] digest = md.digest();
            return HexFormat.of().formatHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
