package org.andgomes;

import org.andgomes.bean.Person;
import org.andgomes.service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger logger =
			LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner cliRunner(
			IPersonService personService) {
		
		return (args) -> {
			logger.info("Ok, I'm ready!");
			
			Person anderson = new Person();
			anderson.setName("Anderson");
			
			Person kotaro = new Person();
			kotaro.setName("Kotaro");
			
			personService.save(anderson);
			personService.save(kotaro);
			
		};
		
	}
	
}
