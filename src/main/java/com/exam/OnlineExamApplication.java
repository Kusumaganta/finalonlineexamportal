package com.exam;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.service.UserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OnlineExamApplication implements CommandLineRunner{
	
	@Autowired         
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
			}
}


