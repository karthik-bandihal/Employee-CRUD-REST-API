package com.jsp.REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee Managment REST API", version = "0.0.1", description = "It is Employee Management Rest Api and it performs CRUD operation"))
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
