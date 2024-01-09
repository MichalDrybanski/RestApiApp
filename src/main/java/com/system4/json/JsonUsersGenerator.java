package com.system4.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.system4.component.UserGeneratorComponent;
import com.system4.component.UserGeneratorComponentImpl;
import com.system4.dto.UserDTO;
import com.system4.dto.UsersDTO;
import com.system4.factory.FakerUserFactory;
import com.system4.factory.RandomCharUserFactory;
import com.system4.factory.UserFactory;
import com.system4.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUsersGenerator {
    private final UserGeneratorComponent userGeneratorComponent;
    private final List<UserDTO> usersList;
    @Autowired
    public JsonUsersGenerator(UserGeneratorComponent userGeneratorComponent) {
        this.userGeneratorComponent = userGeneratorComponent;
        this.usersList = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        UserGeneratorComponent userGeneratorComponent = new UserGeneratorComponentImpl(new FakerUserFactory(new Faker()));
        JsonUsersGenerator jsonUsersGenerator = new JsonUsersGenerator(userGeneratorComponent);
        jsonUsersGenerator.generateUsers();

        UsersDTO usersDTO = new UsersDTO(jsonUsersGenerator.usersList);
        objectMapper.writeValue(new File("generatedUsers.json"), usersDTO);
    }
    public void generateUsers(){
        for(int i = 0; i < 50; i++){
            UserDTO userDTO = userGeneratorComponent.generateUser();
            usersList.add(userDTO);
            System.out.println(userDTO);
        }
    }
//    private static String getRandomChar(){
//        Random random = new Random();
//        char sign = (char) random.nextInt(97, 123);
//        return sign + "";
//    }
//    private static String gerRandomName(){
//        Random random = new Random();
//        int numberLetters = random.nextInt(4, 10);
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < numberLetters; i++){
//            if(i == 0){
//                sb.append(getRandomChar().toUpperCase(Locale.ROOT));
//            }
//            sb.append(getRandomChar());
//        }
//        return sb.toString();
//    }
}

/*
* Zaprojektuj obiektowo narzędzie do generowania obiektów User
*  Przygotuj interface UserFactory z metodą: public User createUser()
*  Przygotuj dwie implementację interfacu RandomCharUserFactory i FakerUserFactory
* */
