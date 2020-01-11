package com.example.demo;

import com.example.demo.DB.facebook.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {
	@Autowired
	private AlTestRepository alTestRepository;
	@Test
	public void contextLoads() {


//		List<com.example.demo.DB.facebook.AlTest> aaaaa=userRepository.findAll();
		List<com.example.demo.DB.facebook.AlTest> aaaaa=alTestRepository.findByAa(1);
		for (com.example.demo.DB.facebook.AlTest alTest: aaaaa){
			System.out.println("========>"+alTest.getAa());
		}



	}

}
