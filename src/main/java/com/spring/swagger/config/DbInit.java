package com.spring.swagger.config;

import com.spring.swagger.model.Task;
import com.spring.swagger.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbInit {
    private static final Logger logger = LoggerFactory.getLogger(DbInit.class);
    @Bean
    CommandLineRunner initDb(TaskRepository taskRepository){
        return args -> {
            logger.info("Preloading data -> "+
                   taskRepository.save(
                           new Task(
                                   "Spring microservices and patterns",
                                   "Implement microservices using spring boot, spring cloud and spring security"))
                   );
            logger.info("Preloading data -> "+
                    taskRepository.save(
                            new Task(
                                    "Learn spring cloud services and best practices",
                                    "Microservices patterns need to be practiced"
                            ))
                    );
        };
    }
}
