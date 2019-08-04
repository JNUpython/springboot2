package com.kean.mybatis.mapper;


import com.kean.mybatis.bean.Employee;
import org.springframework.stereotype.Service;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package shanguigu.mybatis.dao
 * @Description: TODO
 * @date Date : 2019-05-04 13:05
 */

@Service
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

}
