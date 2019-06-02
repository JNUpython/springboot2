package com.shanguigu;

import com.shanguigu.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.shanguigu
 * @Description: TODO
 * @date Date : 2019-05-25 9:52
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShanguiguApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(ShanguiguApplicationTest.class);

    @Autowired
    Person person;

    @Test
    public void testPerson() {
        //Person person = new Person();
        logger.info("{}", person.getName());
    }
}
