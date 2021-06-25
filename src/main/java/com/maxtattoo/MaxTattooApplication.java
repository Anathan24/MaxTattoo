package com.maxtattoo;

import com.maxtattoo.database.entity.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaxTattooApplication {

	private static final Logger logger = LoggerFactory.getLogger(MaxTattooApplication.class);

	public MaxTattooApplication(@Autowired OrderRepository orderRepository){
		var order = orderRepository.findOrderById(1L);
		logger.info("ORDERS: {}", order);
	}

	public static void main(String[] args){
		SpringApplication.run(MaxTattooApplication.class, args);
	}

}
