package com.shanguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu.controller
 * @Description: TODO
 * @date Date : 2019-07-22 23:09
 */

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/success")
    public String success() {
        //classpath:templates/*.html
        return "success";
    }
}
