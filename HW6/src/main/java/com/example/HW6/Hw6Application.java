package com.example.HW6;

import com.example.HW6.View.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw6Application implements CommandLineRunner {

	@Autowired
	Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(Hw6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menu.run();
	}
}
