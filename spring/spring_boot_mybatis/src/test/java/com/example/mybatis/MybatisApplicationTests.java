package com.example.mybatis;

import com.example.mybatis.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    private UserService user;

//    @Test
//    void contextLoads() {
//        user.selectAllUser();
//    }

    @Test
    void insertService() {
        user.insertService();
    }

}
