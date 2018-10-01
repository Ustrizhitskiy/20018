package com.school.server;

import com.school.server.models.Learner;
import com.school.server.repository.LearnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner learner_run(LearnerRepository learnerRepository) {
        return (args) -> {
            learnerRepository.save(new Learner(1L, "Sergey", "Ustrizhitskiy"));
            learnerRepository.save(new Learner(2L, "Oleg", "Afanasiev"));
            learnerRepository.save(new Learner(3L, "Kritina", "Medvedeva"));
        };
    }

}
