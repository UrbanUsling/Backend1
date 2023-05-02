package com.example.demo;

import com.example.demo.Models.Costumer;
import com.example.demo.Models.Varor;
import com.example.demo.Repositories.CostumerRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Repositories.VarorRepository;
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
	public CommandLineRunner demo(CostumerRepository costRepo, OrderRepository orderRepo, VarorRepository varorRepo){
		return (args) -> {
			Costumer c1 = new Costumer("Lawrence", "8808081123");
			Costumer c2 = new Costumer("Indy", "3808081123");
			Costumer c3 = new Costumer("Lola", "3808081123");

			/*Order kund1 = new Order( "435255", c1);
			Order kund2 = new Order( "65464654", c2);
			Order kund3 = new Order( "8768686", c3);*/

			Varor v1 = new Varor("Skor", "700");
			Varor v2 = new Varor("Jacka","1700");
			Varor v3 = new Varor("Hatt", "300");

			costRepo.save(c1);
			costRepo.save(c2);
			costRepo.save(c3);

			/*orderRepo.save(kund1);
			orderRepo.save(kund2);
			orderRepo.save(kund3);*/

			varorRepo.save(v1);
			varorRepo.save(v2);
			varorRepo.save(v3);
		};
	}

}
