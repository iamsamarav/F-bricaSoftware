package com.fabrica.avabank.avabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fabrica.avabank")
public class AvabankApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvabankApplication.class, args);
    }
}
