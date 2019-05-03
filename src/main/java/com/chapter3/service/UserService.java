package com.chapter3.service;

import com.chapter3.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter3.service
 * @Description: TODO
 * @date Date : 2019-02-24 10:56
 */

@Service  // service 也是Component成分会被装配
public class UserService {

    public void printUser(User user) {
        System.out.println("编号：" + user.getUserName());
        System.out.println("ID：" + user.getId());
        System.out.println("NOTE：" + user.getNote());
    }

}
