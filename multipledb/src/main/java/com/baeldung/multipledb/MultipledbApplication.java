package com.baeldung.multipledb;

import org.apache.catalina.startup.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(value = "com.")
public class MultipledbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipledbApplication.class, args);
    }

}
