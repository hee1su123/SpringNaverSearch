package com.example.springstudy2;

import com.example.springstudy2.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductRepository productRepository() {
        String dbUrl = "jdbc:h2:mem:springcoredb";
        String dbId = "sa";
        String dbPassword = "";

        return new ProductRepository(dbUrl, dbId, dbPassword);
    }
}
