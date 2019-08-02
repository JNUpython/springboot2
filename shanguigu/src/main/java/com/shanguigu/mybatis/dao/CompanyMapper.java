package com.shanguigu.mybatis.dao;

import com.shanguigu.mybatis.bean.Company;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu.mybatis.dao
 * @Description: TODO
 * @date Date : 2019-06-07 10:06
 */

public interface CompanyMapper {
    Company selectByCompany(String company);
}
