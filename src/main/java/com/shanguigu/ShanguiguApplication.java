package com.shanguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu.mybatis
 * @Description: TODO
 * @date Date : 2019-05-25 9:09
 *
 */

@SpringBootApplication
//@ImportResource(value = {"classpath:person/person.yml"})
public class ShanguiguApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShanguiguApplication.class, args);
    }
}
