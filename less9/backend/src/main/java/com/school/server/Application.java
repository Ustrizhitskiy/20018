package com.school.server;

import com.school.server.models.Grade;
import com.school.server.models.Learner;
import com.school.server.services.LearnerService;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

        // добавим конфигурацию для логов:
        String pathAppender = "C:\\Users\\sustrizh\\Desktop\\MySchool\\backend\\src\\main\\java\\com\\school\\server\\log4j.properties";
        PropertyConfigurator.configure(pathAppender);
    }

    @Bean
    public CommandLineRunner learner_run(LearnerService learnerService) {

        return (args) -> {

            Grade newGrade = new Grade("11A");
            learnerService.saveGrade(newGrade);

            Learner serg = new Learner("Sergey", "Ustrizhitskiy", newGrade.getId(), newGrade.getGradeName());
            learnerService.saveLearner(serg);
            learnerService.addLearnerToGrade("11A", serg);
            newGrade.addLearnerToGrade(serg);

            Learner kristi = new Learner("Kristina", "Medvedeva", newGrade.getId(), newGrade.getGradeName());
            learnerService.saveLearner(kristi);
            learnerService.addLearnerToGrade("11A", kristi);
            newGrade.addLearnerToGrade(kristi);

            for (int i = 0; i < newGrade.getLearners().size(); i++) {
                System.out.println(newGrade.getLearners().get(i));
            }

        };
    }
}
