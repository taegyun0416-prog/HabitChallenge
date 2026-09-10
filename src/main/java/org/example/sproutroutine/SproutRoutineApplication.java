package org.example.sproutroutine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SproutRoutineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SproutRoutineApplication.class, args);
    }

}
