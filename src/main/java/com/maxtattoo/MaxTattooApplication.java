package com.maxtattoo;

import com.maxtattoo.service.ClientDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaxTattooApplication {

	private static final Logger logger = LoggerFactory.getLogger(MaxTattooApplication.class);

	@Autowired
	private final ClientDataService clientDataService;

	public MaxTattooApplication(@Autowired ClientDataService clientDataService){
		this.clientDataService = clientDataService;
		logger.info("CLIENT: {}", clientDataService.getAllClientData(1L));
	}

	public static void main(String[] args){
		SpringApplication.run(MaxTattooApplication.class, args);
	}

}
