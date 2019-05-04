package com.mybatis;

import com.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.mybatis
 * @Description: TODO
 * @date Date : 2019-05-03 22:59
 */

public class MybatisTest {

    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    /**
     * xml SqlSessionFactory 创建
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        String resource = "mybatis-mysql.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee employee = (Employee) sqlSession.selectOne("com.mybatis.bean.EmployeeMapper.selectEmp", 101);
            logger.info("{} {} {}", employee.getId(), employee.getName(), employee.getSex());
        } finally {
            sqlSession.close();
            logger.info("查询完成!");
        }
    }
}
