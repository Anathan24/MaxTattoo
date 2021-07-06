package com.maxtattoo;

import com.maxtattoo.database.entity.repository.ClientRepository;
import com.maxtattoo.service.interfaces.ClientDataService;
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

	@Autowired
	private ClientRepository clientRepository;

	public MaxTattooApplication(@Autowired ClientDataService clientDataService,
								@Autowired ClientRepository clientRepository){
		this.clientDataService = clientDataService;
		this.clientRepository = clientRepository;

		logger.info("CLIENT: {}", clientRepository.findClientById(1L));
	}

	public static void main(String[] args){
		SpringApplication.run(MaxTattooApplication.class, args);
	}

}
