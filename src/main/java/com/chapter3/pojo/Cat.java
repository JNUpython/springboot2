package com.chapter3.pojo;

import com.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter3.pojo
 * @Description: TODO
 * @date Date : 2019-02-24 13:15
 */

@Component
// @Primary  // 使其相对dog拥有优先的装配权
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("cat");
    }
}
