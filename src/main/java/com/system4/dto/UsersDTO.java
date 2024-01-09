package com.system4.dto;

import java.util.List;

public class UsersDTO {
    private List<UserDTO> users;

    public UsersDTO() {
    }
    public UsersDTO(List<UserDTO> userDTOS) {
        this.users = userDTOS;
    }
    public List<UserDTO> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }

}
