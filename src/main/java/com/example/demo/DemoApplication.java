package com.example.demo;

import com.example.demo.RESTAPI.Varor;
import com.example.demo.RESTAPI.VarorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner addVaror(VarorRepository repository){
		return (args) -> {
			repository.save(new Varor("Gurka","35"));
			repository.save(new Varor("Kyckling","27"));
			repository.save(new Varor("Paprika","32"));
			repository.save(new Varor("Choklad","15"));
			repository.save(new Varor("Champagne","76"));
			repository.save(new Varor("Hamburgare","44"));
			repository.save(new Varor("Pizzabotten","36"));
			repository.save(new Varor("Getost","82"));
		};
	}

}
