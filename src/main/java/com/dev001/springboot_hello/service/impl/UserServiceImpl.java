package com.dev001.springboot_hello.service.impl;

import com.dev001.springboot_hello.entity.user.UserEntity;
import com.dev001.springboot_hello.repository.UserRepository;
import com.dev001.springboot_hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity findByUserNameAndUserEmail(String userName, String userEmail) {
        return userRepository.findByUserNameAndUserEmail(userName,userEmail);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Page<UserEntity> findAllUsersPaging(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> findByUserNamePaging(String userName, Pageable pageable) {
        return userRepository.findByUserName(userName, pageable);
    }

}
