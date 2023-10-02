package com.example.DBMSPro.Config;

import com.example.DBMSPro.Models.Product;
import com.example.DBMSPro.Repository.ProductsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class ProductConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(ProductsRepository productsRepository){
//        return args -> {
//            Product prdt=new Product("rice","Good Prdt",30L,10L,3L, LocalDate.of(1995, Month.SEPTEMBER,6));
//            productsRepository.save(prdt);
//        };
//    }
}
