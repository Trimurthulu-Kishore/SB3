package com.iiht.eva.interviewtkr.controller;

import com.iiht.eva.interviewtkr.entity.User;
import com.iiht.eva.interviewtkr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(value = "id") int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable(value = "id") int userId) {
        userService.deleteUser(userId);
    }


}
