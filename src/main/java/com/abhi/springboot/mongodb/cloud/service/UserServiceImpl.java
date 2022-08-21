package com.abhi.springboot.mongodb.cloud.service;


import com.abhi.springboot.mongodb.cloud.model.User;
import com.abhi.springboot.mongodb.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setCreatedDate(new Date());
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneUser(String id) {
        return userRepository.findById(id);
    }
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> saveUsersList(List<User> user) {
        return userRepository.saveAll(user);
    }

    @Override
    public User updateUser(User user, String id) {
        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent()){
            User updatedUser=optionalUser.get();
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setMobileNumber(user.getMobileNumber());
            return  userRepository.save(updatedUser);
        }else{
           return  null;
          }

    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }


    @Override
    public User loginUser(User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
    }
}
