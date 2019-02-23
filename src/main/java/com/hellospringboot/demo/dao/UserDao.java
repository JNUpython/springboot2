package com.hellospringboot.demo.dao;


import com.hellospringboot.demo.entity.User;
import com.hellospringboot.demo.utils.BeanMap;
import com.mysql.cj.xdevapi.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


// @Service
@Repository
public class UserDao {

    Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        String query = "SELECT * FROM user";
        return jdbcTemplate.queryForList(query).stream().map(n -> {
            logger.info("{}", n);
            User user =  new User();
            user.setId((Long)n.get("id"));
            user.setName((String)n.get("name"));
            user.setAge((Integer)n.get("age"));
            return user;
        }).collect(Collectors.toList());
    }
}
