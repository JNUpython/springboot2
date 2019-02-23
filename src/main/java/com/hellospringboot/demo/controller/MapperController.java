package com.hellospringboot.demo.controller;

import com.hellospringboot.demo.dao.UserDao;
import com.hellospringboot.demo.entity.User;
import com.hellospringboot.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/mysql")
public class MapperController {

    private Logger logger = LoggerFactory.getLogger(MapperController.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @RequestMapping(value = "/getAll2", method = RequestMethod.GET)
    public List<User> getAll2() {
        return userDao.getAll();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute User user) {
        logger.info("{}", user);
        userMapper.insert(user);
        return "insert success";
    }
}
