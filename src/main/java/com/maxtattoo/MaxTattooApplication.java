package com.maxtattoo;

import com.maxtattoo.database.entity.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaxTattooApplication {

	private static final Logger logger = LoggerFactory.getLogger(MaxTattooApplication.class);

	public MaxTattooApplication(@Autowired ClientRepository clientRepository){
		var client = clientRepository.findClientById(1L);
		logger.info("ORDERS: {}", client);
	}

	public static void main(String[] args){
		SpringApplication.run(MaxTattooApplication.class, args);
	}

}
