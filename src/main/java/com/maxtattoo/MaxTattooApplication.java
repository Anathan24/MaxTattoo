package com.maxtattoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class MaxTattooApplication {

	public static void main(String[] args){
		SpringApplication.run(MaxTattooApplication.class, args);
	}

}
