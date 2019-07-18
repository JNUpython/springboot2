package com.ssm.demo;

import com.ssm.demo.dao.CustomerMapperImpl;
import com.ssm.demo.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.ssm.demo
 * @Description: TODO
 * @date Date : 2019-07-18 22:41
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisTest {

    public ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test() {
        Customer customer = new  Customer("lichao", "lichao", "lichao", "lichao");
        CustomerMapperImpl customerMapperImpl = (CustomerMapperImpl) ac.getBean("CustomerMapperImpl");
        customerMapperImpl.saveCustomer(customer);
    }
}
