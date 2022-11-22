package com.example.HW6.repository;

import com.example.HW6.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> getAll() {
        Query selectAllUsers = entityManager.createQuery("SELECT user FROM User user");
        return selectAllUsers.getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = findById(id);
        if (user == null) {
            System.out.println("User not found!");
        } else {
            entityManager.remove(user);
        }
    }
}
