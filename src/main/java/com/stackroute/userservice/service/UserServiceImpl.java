package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import com.stackroute.userservice.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) {
        User saveUser=userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>)userRepository.findAll();
    }


    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user, int id) {
//        return userRepository.findById(id);
        user.setId(id);
        User updateUser =  userRepository.save(user);
        return updateUser;
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }


}

