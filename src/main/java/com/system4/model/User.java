package com.system4.model;

import com.system4.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    private String name;
    private String surname;
    private String login;
    @Id
    @GeneratedValue
    private int id;

    public User() {}

    public User(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }
    public UserDTO toDTO() {
        return new UserDTO(this.name, this.surname, this.login);
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
