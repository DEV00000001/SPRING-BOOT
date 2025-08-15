package com.dev001.springboot_hello.controller.user;

import com.dev001.springboot_hello.entity.user.UserEntity;
import com.dev001.springboot_hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCRUDController {

    @Autowired
    private UserService userService;

    //create user
    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userService.createUser(user);

    }
    //get All users
    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.findAllUsers();
    }
    // search user by name and email
    @GetMapping("/search")
    public UserEntity searchUser(@RequestParam String userName, @RequestParam String userEmail ) {
        return userService.findByUserNameAndUserEmail(userName,userEmail);
    }

}
