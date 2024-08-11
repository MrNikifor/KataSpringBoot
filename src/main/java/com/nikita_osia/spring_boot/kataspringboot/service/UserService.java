package com.nikita_osia.spring_boot.kataspringboot.service;

import com.nikita_osia.spring_boot.kataspringboot.model.User;

import java.util.List;

public interface UserService {
    void saveUser(String firstName, String lastName, String email);

    User showUserById(int id);

    List<User> getAllUsers();

    void updateUserById(int id, User updatedUser);

    void removeUserById(int id);
}
