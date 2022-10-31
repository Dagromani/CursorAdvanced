package com.example.example.Service;

import com.example.example.Entity.User;
import com.example.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    public void addUser(){
        User user = new User("Lesha");
        userRepository.save(user);
    }
}
