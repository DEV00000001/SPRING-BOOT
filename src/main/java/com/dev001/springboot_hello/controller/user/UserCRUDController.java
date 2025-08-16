package com.dev001.springboot_hello.controller.user;

import com.dev001.springboot_hello.entity.user.UserEntity;
import com.dev001.springboot_hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public UserEntity searchUser(@RequestParam String userName, @RequestParam String userEmail) {
        return userService.findByUserNameAndUserEmail(userName, userEmail);
    }

    // get All users paging
    @GetMapping("/paging")
    public Page<UserEntity> getAllUsersPaging(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String order
    ) {
        Sort.Direction sortDirection = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page - 1 , size, sortBy);
        return userService.findAllUsersPaging(pageable);
    }
    // get users paging search by name

    @GetMapping("/paging/search")
    public Page<UserEntity> searchUserPaging(
            @RequestParam int page,
            @RequestParam String userName,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String order) {
        Sort.Direction sortDirection = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page - 1, size, sortBy);
        return userService.findByUserNamePaging(userName, pageable);
    }

}
