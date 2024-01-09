package com.system4.factory;

import com.github.javafaker.Faker;
import com.system4.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FakerUserFactory implements UserFactory{
    private Faker faker;
    @Autowired
    public FakerUserFactory(Faker faker) {
        this.faker = faker;
    }
    @PostConstruct
    public void postConstruct() {
        System.out.println("Faker initialized");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Faker destroyed");
    }
    @Override
    public User createUser() {
        String name = createName();
        String surname = createSurname();
        String login = name + "." + surname + getRandomEmail();
        return new User(name, surname, login.toLowerCase());
    }
    private String createName(){
        return faker.name().firstName();
    }
    private String createSurname(){
        return faker.name().lastName();
    }
    private String getRandomEmail(){
        String [] emails = {"@gmail.com", "@o2.pl", "@interia.eu", "@wp.pl", "@onet.com"};
        return faker.options().option(emails);
    }
}
