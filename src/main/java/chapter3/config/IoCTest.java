package chapter3.config;


import chapter3.pojo.BussinessPerson;
import chapter3.pojo.User;
import chapter3.pojo.definition.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

@Slf4j
public class IoCTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User) applicationContext.getBean("user");
        log.info("{}", user.getId());
        User user2 = (User) applicationContext.getBean("initUser");
        log.info("{}", user2.getId());
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        log.info("{}", dataSource.toString());
        // 通过type获取
        Person person = applicationContext.getBean(BussinessPerson.class);
        person.service();
    }
}
