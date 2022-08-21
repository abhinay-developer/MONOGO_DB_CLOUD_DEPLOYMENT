package com.abhi.springboot.mongodb.cloud.service;

import com.abhi.springboot.mongodb.cloud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);
    public Optional<User> findOneUser(String id);
    public List<User> findAllUsers();
    public List<User> saveUsersList(List<User> user);
    public User updateUser(User user,String id);
    public  void  deleteUser(String id);
    public  User  loginUser(User user);
}
