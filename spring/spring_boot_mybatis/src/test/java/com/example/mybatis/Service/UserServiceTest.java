package com.example.mybatis.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService user;

    @Test
    void selectUserByName() {
        user.selectUserByName("SnailClimb");
    }

    @Test
    void selectAllUser() {
        user.selectAllUser();
    }

    @Test
    void insertService() {
        user.insertUser("escc1122",30,5555);
    }

    @Test
    void deleteService() {
        int i = user.deleteUserByName("escc1122");
        System.out.println(i);
    }
}