package com.iiht.eva.interviewtkr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iiht.eva.interviewtkr.entity.User;
import com.iiht.eva.interviewtkr.service.UserService;

import java.util.List;



@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    //Get Users List
    //http://localhost:9696/trackerapp/api/users/
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    //Get User's Details
    //http://localhost:9696/trackerapp/api/users/1
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(value = "id") int userId) {
        return userService.getUserById(userId);
    }

    // Post User
    //http://localhost:9696/trackerapp/api/users/
    //Body:{ "userId": 1, "fname": "Murthi", "lName": "Murthi", "email": "murthi@iiht.com", "mobile": "0123456789" }
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
  
    //PUT Update User
    //http://localhost:9696/trackerapp/api/users/
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
    // Delete User 
    //http://localhost:9696/trackerapp/api/users/1
    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable(value = "id") int userId) {
        userService.deleteUser(userId);
    }
}