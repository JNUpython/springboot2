package com.shanguigu.springboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package shanguigu.mybatis.bean
 * @Description: TODO
 * @date Date : 2019-05-25 8:58
 */

@Data
@Component
// 如果定义在application配置文件，不需要，如果指定就需要PropertySource 指定文件
@PropertySource(value = {"classpath:person/person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {
    String name;
    String lastName;
    Integer age;
    Boolean sex;
    Dog dog;
    List<Integer> nums;
    Map<String, String> map;

    @Override
    public String toString() {
        return String.format("%s %s %s", name, dog, map);
    }
}
