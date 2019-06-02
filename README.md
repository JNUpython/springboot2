# springboot2
关于SpringBoot2.x的学习

## <<深入浅出SpringBoot2.x>>



hapter3 全注解下的Spring IoC
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
8. @ConfigurationProperties("database") 批量按照属性的名称匹配获取属性值, @PropertySource("classpath:jdbc.properties") // 指定文件
9. @Scope 限定Component使用范围
10. @Value("T(class)") @Value("#{}") 以及配合？判断是否为null继续执行后面方法例如：#{beanName.str?.toUpperCase}
11. spring.profiles.active 拥有最高的环境选择优先级；一般有测试 生产 开发 准生产4套环境，命名方式如application-dev.properties
11. @Profile("dev") 指定bean的properties环境文件.

### AOP IoC 概述
https://juejin.im/post/5c7654e351882562962ef70e

1. pom 文件需要aop
2. @Before("execution(* com.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))") * 代表任何返回类型 
3. @Aspect 切面
4. @PointCut 定义切点
5. @DeclareParents(value= "com.chapter4.aspect.service.impl.UserServiceImpl+", defaultImpl= UserValidatorImpl.class) 新功能



前面没有系统的学习，现在学习尚硅谷的视频；<https://github.com/JNUpython/springboot2/tree/develop>

# lesson1

## mybatis

1. springboot采用自动装配机制，如果引入spring的相关mybatis以及jdbc会自动装配，那么意味我们必须在properties里面添加相关的配置文件。现在直接用mybatis没有用spring的mybatis框架，所以必须注释掉spring关于mybatis的dependency
2. 关于mybatis原生配置：定义全局mybatis的xml配置文件 + 业务表的对应类 + 业务对应的接扣抽象方法 + 抽象方法对应的xml文件（SQL）代码

## springboot

1. @PropertySource

```java
@Data
@Component
// 如果定义在application配置文件，不需要，如果指定就需要PropertySource 指定文件
@PropertySource(value = {"classpath:person/person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {
    String name;
    String lastName;
    Integer age;
    Boolean sex;
    Dog dog;
    List<Integer> nums;
    Map<String, String> map;

    @Override
    public String toString() {
        return String.format("%s %s %s", name, dog, map);
    }
}
```

此方法对应的配置文件必须是properties，yml不会生效

```properties
person.name=kean
person.lastName=lee
person.age=20
person.sex=true
person.dog.name=GG
person.dog.age=2
person.dog.nums=1, 2, 3
person.dog.map.k1=v1
person.dog.map.k2=v2
```





