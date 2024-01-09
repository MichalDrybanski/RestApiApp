package com.system4.dto;

import com.system4.dto.UserDTO;

import java.util.List;

public class UsersDTO {
    private List<UserDTO> userDTOS;

    public UsersDTO() {
    }
    public UsersDTO(List<UserDTO> userDTOS) {
        this.userDTOS = userDTOS;
    }
    public List<UserDTO> getUsers() {
        return userDTOS;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + userDTOS +
                '}';
    }
}
