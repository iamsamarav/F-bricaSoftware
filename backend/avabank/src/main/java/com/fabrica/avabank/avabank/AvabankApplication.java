package com.avanade.avabank.avabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avanade.avabank.avabank.entities.Cliente;

@SpringBootApplication(scanBasePackages = "com.avanade.avabank")
public class AvabankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvabankApplication.class, args);
	}
}
