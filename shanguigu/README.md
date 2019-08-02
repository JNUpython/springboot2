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

### 1.1概述

1. springboot采用自动装配机制，如果引入spring的相关mybatis以及jdbc会自动装配，那么意味我们必须在properties里面添加相关的配置文件。现在直接用mybatis没有用spring的mybatis框架，所以必须注释掉spring关于mybatis的dependency
2. 关于mybatis原生配置：定义全局mybatis的xml配置文件 + 业务表的对应类 + 业务对应的接扣抽象方法 + 抽象方法对应的xml文件（SQL）代码

### 1.2mybatis使用两种烦啊

#### 1.2.1定义全局的mybatis配置文件

```xml-dtd
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!-- 添加公共变量信息：方法1 这样我们就可以用dev配置文件中一些变量  -->
    <properties main.java.resource="jdbc.properties"></properties>
    <!--   自定义一些变量-->
    <!--    <properties>-->
    <!--        <property name="url" value="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=CTT&amp;useUnicode=true&amp;characterEncoding=utf-8&amp;allowMultiQueries=true"/>-->
    <!--        <property name="driver" value="com.mysql.jdbc.Driver"/>-->
    <!--        <property name="username" value="root"/>-->
    <!--        <property name="password" value="123456"/>-->
    <!--    </properties>-->

    <settings>
        <!--   设置数库每个设置项     -->
        <!--   全局地开启或关闭配置文件中的所有映射器已经配置的任何缓存。     -->
        <setting name="cacheEnabled" value="true"/>
    </settings>

    <!--  default 选定不同环境  -->
    <environments default="oracle">
        <environment id="mysql">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${database.driverName2}"/>
                <property name="url" value="${database.url1}"/>
                <property name="username" value="${database.username1}"/>
                <property name="password" value="${database.password1}"/>
            </dataSource>
        </environment>

        <environment id="oracle">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${database.driverName2}"/>
                <property name="url" value="${database.url2}"/>
                <property name="username" value="${database.username2}"/>
                <property name="password" value="${database.password2}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper main.java.resource="mybatis/EmployeeMapper.xml"/>
        <mapper main.java.resource="mybatis/EmployeeMapperInterface.xml"/>
    </mappers>
</configuration>
```

- 通过properties.main.java.resource 指定变量文件信息，并"${database.url1}"方法使用变量
- 可以定义多个数据源
- mapper定义mapper的xml文件位置

#### **1.2.2 定义table类 + xml（这里省略了类代码）**

```xml-dtd
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.shanguigu.mybatis.bean.EmployeeMapper">
<!--
namespace: 命名空间
id： 位移标识
resultType： 返回数据类型
chi
-->
<select id="selectEmp" resultType="com.shanguigu.mybatis.bean.Employee">
        select * from tbl_employee where id = #{id}
    </select>
</mapper>
```

**java调用代码**

```java
// 创建一个session
InputStream inputStream = Resources.getResourceAsStream(main.java.resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "mysql");
SqlSession sqlSession = sqlSessionFactory.openSession();
try {
    // 通过定义sql语句的命名空间定位来执行相应的SQL语句：仅仅需要定义返回类，以及定义的类的sql语句
    Employee employee = sqlSession.selectOne("com.shanguigu.mybatis.bean.EmployeeMapper.selectEmp", 101);
    logger.info("{} {} {}", employee.getId(), employee.getName(), employee.getSex());
} finally {
    sqlSession.close();
    logger.info("查询完成!");
}
```

通过sqlSession.selectOne 的方法执行， 输入的参数为xml的定义业务语句 命名空间 + 方法具体id

#### **1.2.3常用的方法：table类 + 抽象方法接口 + xml文件**

```xml-dtd
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.shanguigu.mybatis.dao.EmployeeMapper">
    <!--
    namespace: 命名空间, 与接口对应
    id： 位移标识， 必须与接口定义的方法一致
    resultType： 返回数据类型
    -->
    <select id="getEmpById" resultType="com.shanguigu.mybatis.bean.Employee">
        select * from tbl_employee where id = #{id}
    </select>
</mapper>
```

命名空间与dao定义的interface路径一致，不是强制为了可读性，xml中的id与interface定义的方法必须一致。

**抽象类的定义**:getEmpById

```java
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

}
```

**java 采用反射代理机制对抽象接口方法调用**:sqlSession.getMapper

```java
InputStream inputStream = Resources.getResourceAsStream(main.java.resource);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
SqlSession sqlSession = sqlSessionFactory.openSession();
try {
    // 代理机制获取接口对应的类
    EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    logger.info("Mapper class: {}", employeeMapper.getClass());
    // 定义接口，以及xml文件命名空间和方法名必须意义对应
    Employee employee = employeeMapper.getEmpById(101);
    logger.info("{} {} {}", employee.getId(), employee.getName(), employee.getSex());
} finally {
    sqlSession.close();
    logger.info("查询完成!");
}
```

#### 1.2.4 使用resultMap mybatis高级属性定义返货数据类型

<https://blog.csdn.net/wangduanqs/article/details/85023293>

```
association:left join 的右边只有唯一返回值
collection:left join 的右边多个返回值
```



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

### 尚硅谷 学习github
https://github.com/cyhbyw/springBoot_atguigu
https://www.bilibili.com/video/av20965295?from=search&seid=8089348542796890010




