package com.example.demo;

import com.example.demo.Models.Customer;
import com.example.demo.Models.Item;
import com.example.demo.Models.Orders;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.OrdersRepository;
import com.example.demo.Repositories.ItemsRepository;
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
	public CommandLineRunner demo(CustomerRepository costRepo, OrdersRepository orderRepo, ItemsRepository varorRepo){
		return (args) -> {
			Customer c1 = new Customer("Lawrence", "8808081123");
			Customer c2 = new Customer("Indy", "3808081123");
			Customer c3 = new Customer("Lola", "3808081123");



			Item v1 = new Item("Skor", "700");
			Item v2 = new Item("Jacka","1700");
			Item v3 = new Item("Hatt", "300");

			Orders order1 = new Orders( "2022-12-12", c2);
			order1.addItems(v1);
			Orders order2 = new Orders( "2023-01-03", c2);
			order2.addItems(v2);
			Orders order3 = new Orders( "2023-02-16", c3);
			order3.addItems(v3);

			costRepo.save(c1);
			costRepo.save(c2);
			costRepo.save(c3);

			orderRepo.save(order1);
			orderRepo.save(order2);
			orderRepo.save(order3);

			varorRepo.save(v1);
			varorRepo.save(v2);
			varorRepo.save(v3);
		};
	}

}
