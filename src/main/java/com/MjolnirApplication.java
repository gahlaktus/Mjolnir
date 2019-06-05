package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@ComponentScan(basePackages = {"com.stark"})
public class MjolnirApplication {

    public static void main(String[] args) {
        SpringApplication.run(MjolnirApplication.class, args);
    }

}