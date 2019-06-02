package com.shanguigu.springboot.bean;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package shanguigu.mybatis.bean
 * @Description: TODO
 * @date Date : 2019-05-25 8:59
 */

class Dog {
    String name;
    Integer age;

    @Override
    public String toString() {
        return String.format("dog: {name: %s, age: %d}", name, age);
    }
}
