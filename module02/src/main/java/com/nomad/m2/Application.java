package com.nomad.m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Application {

    @Autowired
    private Environment env;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

}
