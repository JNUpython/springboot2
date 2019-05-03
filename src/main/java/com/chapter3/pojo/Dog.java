package com.chapter3.pojo;

import com.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @author : kean
 * @version V1.0
 * @Project: learnSpingBoot
 * @Package com.chapter3.pojo
 * @Description: TODO
 * @date Date : 2019-02-18 23:58
 */

@Component
public class Dog implements Animal {

    @Override
    public void use() {
        System.out.println("dog");
    }
}
