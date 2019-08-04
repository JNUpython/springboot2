package com.kean.mybatis.mapper;


import com.kean.mybatis.bean.Company;
import org.springframework.stereotype.Service;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu.mybatis.dao
 * @Description: TODO
 * @date Date : 2019-06-07 10:06
 */
@Service
public interface CompanyMapper {
    Company selectByCompany(String company);
}
