package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    User updateUser(User user, int id);
    void deleteUserById(int id);
}
