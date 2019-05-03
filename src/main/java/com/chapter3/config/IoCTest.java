package com.chapter3.config;


// @Slf4j
// public class IoCTest {
//
//     public static void main(String[] args) {
//         ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//         User user = (User) applicationContext.getBean("user");
//         log.info("{}", user.getId());
//         User user2 = (User) applicationContext.getBean("initUser");
//         log.info("{}", user2.getId());
//         DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
//         log.info("{}", dataSource.toString());
//         // 通过type获取
//         Person person = applicationContext.getBean(BussinessPerson.class);
//         person.service();
//         person.setAnimal(new Cat());
//         person.service();
//         // Service
//         UserService userService = applicationContext.getBean(UserService.class);
//         userService.printUser(user);
//     }
// }
