package com.system4.factory;

import com.system4.model.User;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;
@Component
public class RandomCharUserFactory implements UserFactory{
    @Override
    public User createUser() {
        String name = gerRandomString();
        String surname = gerRandomString();
        String login = name + "." + surname + "@" + gerRandomString() + ".com";
        return new User(name, surname, login.toLowerCase());
    }
        private static String getRandomChar(){
        Random random = new Random();
        char sign = (char) random.nextInt(97, 123);
        return sign + "";
    }
    private static String gerRandomString(){
        Random random = new Random();
        int numberLetters = random.nextInt(4, 10);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numberLetters; i++){
            if(i == 0){
                sb.append(getRandomChar().toUpperCase(Locale.ROOT));
            }
            sb.append(getRandomChar());
        }
        return sb.toString();
    }
}
