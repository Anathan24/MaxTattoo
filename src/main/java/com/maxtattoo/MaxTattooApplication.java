package com.maxtattoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class MaxTattooApplication {

	private static Logger logger = LoggerFactory.getLogger(MaxTattooApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MaxTattooApplication.class, args);

	}

//	private void httpResponceExample(){
//		logger.info("Hello world");
//		new ResponseEntity<>("OK", HttpStatus.OK);
//	}
}
