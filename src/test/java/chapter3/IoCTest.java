package chapter3;

import chapter3.config.AppConfig;
import chapter3.pojo.BussinessPerson;
import chapter3.pojo.Cat;
import chapter3.pojo.DataBaseProperties;
import chapter3.pojo.User;
import chapter3.pojo.definition.Person;
import chapter3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter3
 * @Description: TODO
 * @date Date : 2019-02-24 15:58
 */

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
        person.setAnimal(new Cat());
        person.service();
        // Service
        UserService userService = applicationContext.getBean(UserService.class);
        userService.printUser(user);
        // DataBaseProperties
        DataBaseProperties dataBaseProperties = applicationContext.getBean(DataBaseProperties.class);
        dataBaseProperties.print();
        log.info("{}", dataBaseProperties);
    }
}
