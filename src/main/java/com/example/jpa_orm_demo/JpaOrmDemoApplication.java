package com.example.jpa_orm_demo;

import com.example.jpa_orm_demo.repository.ProductDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaOrmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaOrmDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		ProductDao productDao = new ProductDao();
		return args -> {
			System.out.println(productDao.save());
			System.out.println(productDao.findById(1));
			System.out.println(productDao.updateById(1));
			productDao.deleteById(1);

		};
	}

}
