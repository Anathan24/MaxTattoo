package com.maxtattoo;

import com.maxtattoo.database.entity.Client;
import com.maxtattoo.database.entity.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaxTattooApplication {

	private static Logger logger = LoggerFactory.getLogger(MaxTattooApplication.class);

	@Autowired
	private static  ClientRepository clientRepository;

	public MaxTattooApplication(@Autowired ClientRepository clientRepository){
		this.clientRepository = clientRepository;
		Client client = this.clientRepository.findClientById(1L);
		logger.info("CLIENT: {}", client.toString());
	}

	public static void main(String[] args)
	{
		SpringApplication.run(MaxTattooApplication.class, args);
	}

//	private void httpResponceExample(){
//		logger.info("Hello world");
//		new ResponseEntity<>("OK", HttpStatus.OK);
//	}

}
