package com.itgarden.ERP;

// start date 05/06/2018 1.58 pm
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class ErpApplication {
    
    

    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }

}
