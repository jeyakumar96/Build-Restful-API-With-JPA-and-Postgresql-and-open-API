package com.example.employee_management;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee-Management",
				version = "0.0.1-SNAPSHOT",
				description = "Build Restful API With JPA and Postgresql",
				termsOfService = "Java Spring Boot Service",
				contact = @Contact(name = "Jeyakumar", email = "krishkumar85@gmail.com"),
				license = @License(name = "Jai")
		)
)
@ComponentScan(basePackages = "com.example.employee_management")
@EnableJpaRepositories(basePackages = "com.example.employee_management.repository")
@EntityScan(basePackages = "com.example.employee_management.entity")
@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
}
