package com.kean.mybatis.bean;

import lombok.Data;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package shanguigu.mybatis
 * @Description: TODO
 * @date Date : 2019-05-03 23:17
 */
@Data
public class Employee {
    Integer id;
    String name;
    String sex;
    Integer companyId;
}
