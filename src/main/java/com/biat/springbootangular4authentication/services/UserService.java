package com.biat.springbootangular4authentication.services;

import com.biat.springbootangular4authentication.dao.UserRepository;
import com.biat.springbootangular4authentication.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user) {
       return  userRepository.saveAndFlush(user);

    }
    public User find(String userName) {
        return userRepository.findByUsername(userName);
    }
    public User find(Long id) {
       return userRepository.findOne(id);
    }
    public User update(User user) {
        return userRepository.save(user);
    }

}

