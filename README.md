# springboot2
关于SpringBoot2.x的学习

## <<深入浅出SpringBoot2.x>>

### 第3章全注解下的Spring IoC
```
java 的的配置文件， 程序
@Configuration  
class AppConfig ...

调用Bean
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
User user = (User) applicationContext.getBean("user");

```
1. 在Spring中把需要管来的对象称为Bean， 管理这些Bean的容器称为IoC容器
2. 通过类型和名称获取Bean。
3. 默认是单例模式，isSingleton判断。相反为isProtoType.
4. @Autowired 对Component的成员变量进行自动装配时，会根据成员Class Type进行自动装配。但是存在多个
类冲突时，根据成员变量命名来识别。初次之外还有@Qualifier("cat")和@Primary 来消除歧义
5. Bean的初始化到销毁叫生命周期。
6. @ComponentScan 默认lazyInit为true，即只有被装配的Bean被调用时才会被初始化。
7. @Value("${database.driverName}") 此方法获取application.properties中的属性值
8. @ConfigurationProperties("database") 批量按照属性的名称匹配获取属性值
9. @Scope 限定Component使用范围
10. @Value("T(class)") @Value("#{}") 以及配合？判断是否为null继续执行后面方法例如：#{beanName.str?.toUpperCase}
11. spring.profiles.active 拥有最高的环境选择优先级；一般有测试 生产 开发 准生产4套环境，命名方式如application-dev.properties
11. @Profile("dev") 指定bean的properties环境文件.
