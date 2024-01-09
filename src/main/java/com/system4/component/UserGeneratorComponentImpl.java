package com.system4.component;

import com.system4.dto.UserDTO;
import com.system4.factory.UserFactory;
import com.system4.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGeneratorComponentImpl implements UserGeneratorComponent{
    private final UserFactory userFactory;
    @Autowired
    public UserGeneratorComponentImpl(UserFactory userFactory) {
        this.userFactory = userFactory;
    }
    @PostConstruct
    public void postConstruct() {
        System.out.println("UserGeneratorComponent initialized");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("UserGeneratorComponent destroyed");
    }

    @Override
    public UserDTO generateUser() {
        return userFactory.createUser().toDTO();
    }
}
