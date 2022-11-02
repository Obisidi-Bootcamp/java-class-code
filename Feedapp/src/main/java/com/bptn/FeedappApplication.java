package com.bptn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FeedappApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedappApplication.class, args);
    }

}
