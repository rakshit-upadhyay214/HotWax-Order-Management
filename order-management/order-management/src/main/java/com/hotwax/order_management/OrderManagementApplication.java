package com.hotwax.order_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"main.app", "controller", "service", "model", "repository"})
@EnableJpaRepositories("repository")
@EntityScan("model")
public class OrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}
}
