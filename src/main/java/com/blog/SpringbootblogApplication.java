package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootblogApplication.class, args);
    }

}
