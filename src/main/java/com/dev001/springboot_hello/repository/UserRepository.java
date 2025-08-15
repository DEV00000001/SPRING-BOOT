package com.dev001.springboot_hello.repository;

import com.dev001.springboot_hello.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    // where userName = ?1 and userEmail = ?2
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    // where userName = ?1
    UserEntity findByUserName(String userName);

    /*
    * WHERE userName LIKE %?
    * */
    List<UserEntity> findByUserNameStartingWith(String userName);
    /*
     * WHERE userName LIKE %?
     * */
    List<UserEntity> findByUserNameEndingWith(String userName);

    /*
     * WHERE id < 1
     * */
    List<UserEntity> findByIdLessThan(Long id);

    //RAW JPQL QUERY
    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntitiesBy(String userName, String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail")
    List<UserEntity> getUserEntitiesByTwo(@Param("userName") String userName,@Param("userEmail")String userEmail);

    /*
    * UPDATE DELETE
    * */
    @Modifying
    @Query("UPDATE UserEntity u SET u.userName = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    /*
    * NATIVE QUERY
    * */
    @Query(value="SELECT COUNT(id) FROM user", nativeQuery = true)
    long getTotalUser();










}
