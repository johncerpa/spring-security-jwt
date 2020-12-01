package com.john.demo;

import com.john.demo.entities.User;
import com.john.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(1, "john", "john_password", "john@gmail.com"),
                new User(2, "leidy", "leidy_password", "leidy@gmail.com")
        ).collect(Collectors.toList());

        userRepository.saveAll(users);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }
}
