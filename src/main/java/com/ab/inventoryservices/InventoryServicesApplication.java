package com.ab.inventoryservices;

import com.ab.inventoryservices.entities.Product;
import com.ab.inventoryservices.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Product.class);
		return args -> {
			productRepository.save(new Product(null,"product1",100,15));
			productRepository.save(new Product(null,"product2",200,20));
			productRepository.save(new Product(null,"product3",300,25));
			productRepository.findAll().forEach(product -> {
				System.out.println(product.toString());
			});

		};
	}
}
