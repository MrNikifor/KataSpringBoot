package com.nikita_osia.spring_boot.kataspringboot.dao;

import com.nikita_osia.spring_boot.kataspringboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;




import java.util.List;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(String firstName, String lastName, String email) {
        entityManager.persist(new User(firstName, lastName, email));
    }

    @Override
    @Transactional
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUserById(int id, User updatedUser) {
        User userToBeUpdated = entityManager.find(User.class, id);
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastname(updatedUser.getLastname());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    @Transactional
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
