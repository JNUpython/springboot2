package chapter3;

import chapter3.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter3
 * @Description: TODO
 * @date Date : 2019-02-24 16:02
 */

@Slf4j
public class LifeCycleTest {

    // private static Logger log = Logger.getLogger(LifeCycleTest.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext.close();
        // log.info("ssss");
        log.info("{}", log);
        log.info("{}", "---------------- end ----------------");
    }
}
