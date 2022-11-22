package com.example.HW5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Hw5Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Hw5Application.class, args);
        User user = context.getBean(User.class);
        System.out.println(user.getName());
    }


}
