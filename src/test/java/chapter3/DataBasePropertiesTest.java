package chapter3;

import chapter3.config.AppConfig;
import chapter3.pojo.DataBaseProperties;
import com.hellospringboot.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter3
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
