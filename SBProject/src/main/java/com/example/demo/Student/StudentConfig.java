package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mani=new Student(
                    "mani",
                    "mani@gmail.com",
                    LocalDate.of(2003, Month.SEPTEMBER,6)
            );
            Student Ram=new Student(
                    "Ram",
                    "Ram@gmail.com",
                    LocalDate.of(2002, Month.SEPTEMBER,6)
            );
            repository.saveAll(List.of(mani,Ram));
        };
    }
}
