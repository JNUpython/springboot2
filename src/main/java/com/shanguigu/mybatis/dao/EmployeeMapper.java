package com.shanguigu.mybatis.dao;


import com.shanguigu.mybatis.bean.Employee;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package shanguigu.mybatis.dao
 * @Description: TODO
 * @date Date : 2019-05-04 13:05
 */

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

}
