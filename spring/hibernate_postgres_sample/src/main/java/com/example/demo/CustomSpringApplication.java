package com.example.demo;

import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alma on 2019/10/21.
 */
public class CustomSpringApplication {
  public static SpringApplication getInstance(Class... primarySources){
    SpringApplication springApplication = new SpringApplication(primarySources);
    Map<String, Object> pro = new HashMap<>();
    pro.put("spring.datasource.url", "jdbc:postgresql://127.0.0.1:5432/postgres");
    springApplication.setDefaultProperties(pro);
    return springApplication;
  }
}
