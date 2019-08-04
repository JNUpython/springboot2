package com.kean.mybatis.controller;

import com.kean.mybatis.bean.Company;
import com.kean.mybatis.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.kean.mybatis.controller
 * @Description: TODO
 * @date Date : 2019-08-04 12:46
 */

@RestController
public class Hello {

    @Autowired
    CompanyMapper companyMapper;

    //@PostMapping(value = "/hello")
    @GetMapping(value = "/hello")
    public Company hello() {
        return companyMapper.selectByCompany("alibaba");
    }
}
