package com.ssm.demo.dao;

import com.ssm.demo.entity.Customer;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.ssm.demo.dao
 * @Description: TODO
 * @date Date : 2019-07-18 22:57
 *
 * 整合mybatis + spring
 */

public class CustomerMapperImpl extends SqlSessionDaoSupport implements CustomerMapper {

    @Override
    public void saveCustomer(Customer customer) {
        // 这里SqlSessionDaoSupport并没有事先注入
        SqlSession sqlSession =  this.getSqlSession();
        sqlSession.insert("saveCustomer", customer);
        logger.info("saved customer: " + customer.getName());
        sqlSession.close();
    }
}
