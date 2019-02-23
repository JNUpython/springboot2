package com.hellospringboot.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BlogProperties {

    @Value("${com.didispace.blog.name}")
    private String name;

    @Value("${com.didispace.blog.title}")
    private String title;

    @Value("${com.dispspace.blog.root}")
    private String blogRoot;

    @Value("${com.dispspace.blog.randomString}")
    private String rangValue;
}
