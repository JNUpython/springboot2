package com.hellospringboot.demo.mapper;


import com.hellospringboot.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
// @Service
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    // @Insert("INSERT user VALUES (100006 , 'lichao', 24)")
    @Insert("INSERT user VALUES (#{user.id} , #{user.name}, #{user.age})")
    void insert(@Param("user") User user);
}
