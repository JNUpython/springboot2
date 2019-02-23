package com.hellospringboot.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {

    @Value("${user.id}")
    private Long id;

    private String name;

    private Integer age;

}
