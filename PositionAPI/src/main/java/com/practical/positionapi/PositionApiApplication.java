package com.practical.positionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
    "com.practical.positionapi.controller",
    "com.practical.positionapi.model",
    "com.practical.positionapi.service",
    "com.practical.positionapi.repo"
})
/**
 * The entry point of the Spring Boot application.
 *
 * @param  args  the command line arguments
 */
public class PositionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PositionApiApplication.class, args);
    }

}
