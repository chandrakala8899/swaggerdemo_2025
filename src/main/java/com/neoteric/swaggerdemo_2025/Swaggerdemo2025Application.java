package com.neoteric.swaggerdemo_2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class Swaggerdemo2025Application {

	public static void main(String[] args) {
		SpringApplication.run(Swaggerdemo2025Application.class, args);
	}

}
