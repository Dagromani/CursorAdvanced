package com.example.example;

import com.example.example.Entity.User;
import com.example.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.example.Repository" , "com.example.example.Service"})
@SpringBootApplication
public class ExampleApplication implements CommandLineRunner {

//		@Autowired
//		UserRepository userRepository;

		@Autowired
		UserService userService;

	public static void main(String[] args) {
		UserService userService = new UserService();
		SpringApplication.run(ExampleApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User("Lesha");
//		userRepository.save(user);

		userService.addUser();
	}
}
