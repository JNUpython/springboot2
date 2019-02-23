package com.hellospringboot.demo.controller;


import com.hellospringboot.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private User user;

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User >());

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<User> getUserList() {
        // return users.values().stream().collect(Collectors.toList());
        return new ArrayList<>(users.values());
    }

    @RequestMapping(value ="/postUser1", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @RequestMapping("/postUser2")
    public String postUser(@RequestParam(required = true) String name,
                           @RequestParam(required = false) Integer age) {
        user.setName(name);
        user.setAge(age);
        users.put(user.getId(), user);
        return "post2 user: " + user.getId();
    }


    @RequestMapping(value="/getUser/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value="/putUser/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value="/deleteUser/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
