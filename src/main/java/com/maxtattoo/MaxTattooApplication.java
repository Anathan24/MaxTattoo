package com.maxtattoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaxTattooApplication {

	private static Logger logger = LoggerFactory.getLogger(MaxTattooApplication.class);

	public static void main(String[] args) {
		logger.info("Hello world");
		SpringApplication.run(MaxTattooApplication.class, args);
	}

}
