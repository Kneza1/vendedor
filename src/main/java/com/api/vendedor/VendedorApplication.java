package com.api.vendedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.api.vendedor")
public class VendedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendedorApplication.class, args);
	}

}
