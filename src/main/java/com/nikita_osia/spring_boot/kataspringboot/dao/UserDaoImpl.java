package com.nikita_osia.spring_boot.kataspringboot.dao;

import com.nikita_osia.spring_boot.kataspringboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;




import java.util.List;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(String firstName, String lastName, String email) {
        entityManager.persist(new User(firstName, lastName, email));
    }

    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUserById(int id, User updatedUser) {
        User userToBeUpdated = entityManager.find(User.class, id);
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastname(updatedUser.getLastname());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
