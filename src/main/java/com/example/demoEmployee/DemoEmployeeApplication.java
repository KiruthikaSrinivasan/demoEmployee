package com.example.demoEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "employeeController" , "employeeService" , "entityEmployee"})
public class DemoEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEmployeeApplication.class, args);
	}
	
	
}
