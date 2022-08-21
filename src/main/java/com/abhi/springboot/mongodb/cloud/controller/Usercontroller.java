package com.abhi.springboot.mongodb.cloud.controller;

import com.abhi.springboot.mongodb.cloud.exeption.NoRecordsFoundException;
import com.abhi.springboot.mongodb.cloud.model.User;
import com.abhi.springboot.mongodb.cloud.service.UserService;
import com.abhi.springboot.mongodb.cloud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Usercontroller {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        User createUser=userService.saveUser(user);
        return  new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<?> findAllUser(){
        List<User> usersList=userService.findAllUsers();
        return  new ResponseEntity<>(usersList, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> findUserById(@PathVariable String id) throws NoRecordsFoundException {
        Optional<User> user=userService.findOneUser(id);
        if (user.isPresent()) {
            return  new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            throw new NoRecordsFoundException("No Records Found");
        }
    }
    @PostMapping("/saveAllUsers")
    public ResponseEntity<?> saveAllUsers(@RequestBody List<User> users){
        List<User> usersList=userService.saveUsersList(users);
        return  new ResponseEntity<>(usersList, HttpStatus.CREATED);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        Map<String,String> map=new HashMap<>();
             map.put(id,"Deleted Successfully");
             userService.deleteUser(id);
        return  new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PatchMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String id){
        User updatedUser=userService.updateUser(user,id);
        return  new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User loggedInUser=userService.loginUser(user);
        if(loggedInUser!=null){
            return  new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
