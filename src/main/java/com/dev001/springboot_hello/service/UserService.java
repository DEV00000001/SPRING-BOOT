package com.dev001.springboot_hello.service;

import com.dev001.springboot_hello.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);
    List<UserEntity> findAllUsers();

    // get all by limit offset
    Page<UserEntity> findAllUsersPaging(Pageable pageable);

    // get search by limit offset
    Page<UserEntity> findByUserNamePaging(String userName, Pageable pageable);
}
