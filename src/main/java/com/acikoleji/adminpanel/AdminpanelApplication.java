package com.acikoleji.adminpanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AdminpanelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminpanelApplication.class, args);
	}

}
