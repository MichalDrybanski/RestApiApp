package com.system4.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system4.dto.UserDTO;
import com.system4.dto.UsersDTO;
import com.system4.factory.UserFactory;
import com.system4.model.User;
import com.system4.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserGenerator {
    private final UserFactory userFactory;
    private final UserRepository repository;
    private final ObjectMapper objectMapper;
    @Autowired
    public UserGenerator(UserFactory userFactory, UserRepository repository) {
        this.userFactory = userFactory;
        this.repository = repository;
        objectMapper = new ObjectMapper();
    }
    @PostConstruct
    public void postConstruct() throws IOException {
        if (repository.count() > 0) {
            return;
        }
        System.out.println("UserGeneratorComponent initialized");
        List<User> users = generateUsers();
        repository.saveAll(users);
        List<UserDTO> usersDTOs = users.stream()
                        .map(user -> new UserDTO(user.getName(),user.getSurname(),user.getLogin()))
                                .toList();
        objectMapper.writeValue(new File("generatedUsers.json"), new UsersDTO(usersDTOs));
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("UserGeneratorComponent destroyed");
    }
    public List<User> generateUsers(){
        List<User> users = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            User user = userFactory.createUser();
            users.add(user);
        }
        return users;
    }
}
