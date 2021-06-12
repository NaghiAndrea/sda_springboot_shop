package com.sda.andreanaghi.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.sda.andreanaghi.webshop.repository")
//@EntityScan(basePackages = "com.sda.andreanaghi.webshop.model")
public class RestWebshopApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestWebshopApplication.class, args);

    }

}
