package com.example.simplerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SimplerestApplication {

	@PostConstruct
	void setDefaultTimezone() {
    	TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SimplerestApplication.class, args);
	}

}
