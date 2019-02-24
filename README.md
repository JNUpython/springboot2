# springboot2
关于SpringBoot2.x的学习

## <<深入浅出SpringBoot2.x>>

### 第3章全注解下的Spring IoC
1. 在Spring中把需要管来的对象称为Bean， 管理这些Bean的容器称为IoC容器
2. 通过类型和名称获取Bean。
3. 默认是单例模式，isSingleton判断。相反为isProtoType.
4. @Autowired 对Component的成员变量进行自动装配时，会根据成员Class Type进行自动装配。但是存在多个
类冲突时，根据成员变量命名来识别。初次之外还有@Qualifier("cat")和@Primary 来消除歧义
