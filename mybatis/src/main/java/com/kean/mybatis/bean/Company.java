package com.kean.mybatis.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu.mybatis.bean
 * @Description: TODO
 * @date Date : 2019-06-07 10:03
 */

@Data
@ToString
public class Company {
    Integer id;
    String company;
    Boss boss;
    List<Employee> employeeList;
}
