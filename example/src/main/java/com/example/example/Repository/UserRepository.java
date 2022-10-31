package com.example.example.Repository;

import com.example.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }
}
