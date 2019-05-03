package com.chapter4.service.impl;

import com.chapter4.service.HelloService;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter4.service.impl
 * @Description: TODO
 * @date Date : 2019-02-24 21:42
 */

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new RuntimeException("error name!");
        }
        System.out.println("hello + " + name);
    }
}
