package com.nikita_osia.spring_boot.kataspringboot.service;

import com.nikita_osia.spring_boot.kataspringboot.dao.UserDao;
import com.nikita_osia.spring_boot.kataspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(String firstName, String lastName, String email) {

    }

    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUserById(int id, User updatedUser) {
        userDao.updateUserById(id, updatedUser);
    }

    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);
    }
}
