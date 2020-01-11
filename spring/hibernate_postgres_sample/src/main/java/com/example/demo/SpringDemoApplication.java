package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDemoApplication.class, args);
		
//		Map<String, Object> pro = new HashMap<>();
//		pro.put("spring.datasource.url", "jdbc:postgresql://127.0.0.1:5432/postgres");
//
//		springApplication.setDefaultProperties(pro);
//		ApplicationContext ctx = springApplication.run(args);

//		System.out.println("List all beans: ");
//
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
	}

}
