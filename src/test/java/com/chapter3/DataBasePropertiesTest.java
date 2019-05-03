package com.chapter3;

import com.chapter3.pojo.DataBaseProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter3
 * @Description: TODO
 * @date Date : 2019-02-24 17:14
 */

@Slf4j
public class DataBasePropertiesTest {

    @Autowired
    DataBaseProperties dataBaseProperties = null;

    @Test
    public void test1() {
        log.info("{}", dataBaseProperties);
    }
}
