package com.system4.dto;

import com.system4.model.User;

public class UserDTO {
    private String name;
    private String surname;
    private String login;
    public UserDTO() {
    }
    public UserDTO(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }
}
