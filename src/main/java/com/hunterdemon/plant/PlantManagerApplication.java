package com.hunterdemon.plant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class PlantManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantManagerApplication.class, args);
	}

}
