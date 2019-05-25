package com.shanguigu.mybatis;

import com.shanguigu.mybatis.bean.Employee;
import com.shanguigu.mybatis.dao.EmployeeMapper;
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
 * @Package shanguigu.mybatis
 * @Description: TODO
 * @date Date : 2019-05-03 22:59
 */

public class MybatisTest {

    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    private static final String resource = "mybatis/mybatis-mysql.xml";

    /**
     * xml SqlSessionFactory 创建
     * 传统方法
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        // 创建一个session
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "mysql");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 通过定义sql语句的命名空间定位来执行相应的SQL语句：仅仅需要定义返回类，以及定义的类的sql语句
            Employee employee = sqlSession.selectOne("com.shanguigu.mybatis.bean.EmployeeMapper.selectEmp", 101);
            logger.info("{} {} {}", employee.getId(), employee.getName(), employee.getSex());
        } finally {
            sqlSession.close();
            logger.info("查询完成!");
        }
    }

    /**
     * 采用接口的方法
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 代理机制获取接口对应的类
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            logger.info("Mapper class: {}", employeeMapper.getClass());
            // 定义接口，以及xml文件命名空间和方法名必须意义对应
            Employee employee = employeeMapper.getEmpById(101);
            logger.info("{} {} {}", employee.getId(), employee.getName(), employee.getSex());
        } finally {
            sqlSession.close();
            logger.info("查询完成!");
        }
    }

    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            logger.info("Mapper class: {}", employeeMapper.getClass());
            Employee employee = employeeMapper.getEmpById(101);
            logger.info("{} {} {}", employee.getId(), employee.getName(), employee.getSex());
        } finally {
            sqlSession.close();
            logger.info("查询完成!");
        }
    }
}
