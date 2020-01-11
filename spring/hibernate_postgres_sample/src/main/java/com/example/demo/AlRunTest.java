package com.example.demo;

import com.example.demo.DB.facebook.AlTest;
import com.example.demo.DB.facebook.AlTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alma on 2019/10/16.
 */
@Component
public class alRunTest {
  @Autowired
  private AlTestRepository alTestRepository;
  public static void main(String[] args) {
    System.out.println("alRunTest start");
    SpringApplication springApplication = CustomSpringApplication.getInstance(SpringDemoApplication.class);
    ApplicationContext ctx = springApplication.run(args);



    alRunTest alRunTest = (alRunTest)ctx.getBean(alRunTest.class);
    alRunTest.Do();

    System.out.println("alRunTest end");

  }

  public void Do(){
    System.out.println("alRunTest Do start");
    List<AlTest> aaaaa = alTestRepository.findByAaD();
    for (com.example.demo.DB.facebook.AlTest alTest: aaaaa){
      System.out.println("====aa====>"+alTest.getAa());
    }
  }


}
