package com.hellospringboot.demo;


import com.hellospringboot.demo.config.BlogProperties;
import com.hellospringboot.demo.config.HomeProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConfigTest {

    private Logger logger = LoggerFactory.getLogger(ConfigTest.class);

    @Autowired private BlogProperties blogProperties;

    @Autowired private HomeProperties homeProperties;
    
    @Test
    public void blogPropertiesTest() {
        logger.info( "{}, {} {} {}", blogProperties.getName(), blogProperties.getTitle(), blogProperties.getBlogRoot(), blogProperties.getRangValue());
    }

    @Test public void homePropertiesTest() {
        logger.info("{}", homeProperties);
    }
}
