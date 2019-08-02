package com.baeldung.multipledb.controller;

import com.baeldung.multipledb.dao.product.ProductRepository;
import com.baeldung.multipledb.dao.user.UserRepository;
import com.baeldung.multipledb.model.product.Product;
import com.baeldung.multipledb.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.baeldung.multipledb.controller
 * @Description: TODO
 * @date Date : 2019-08-03 0:57
 */

@RestController
@RequestMapping("/")
@Slf4j
public class Controller {

    //public boolean insertUser(int id, String name, String email, int age) {
    //    User user = new User(id, name, email, age);
    //}

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "test", method = {RequestMethod.GET})
    public boolean test() {
        User user = userRepository.selectOneById(0);
        Product product = productRepository.selectOneById(0);
        log.info("user：{}", user);
        log.info("product：{}", product);
        return true;
    }
}
