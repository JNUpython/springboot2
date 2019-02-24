package chapter3.pojo;

import chapter3.pojo.definition.Animal;
import chapter3.pojo.definition.Person;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : kean
 * @version V1.0
 * @Project: learnSpingBoot
 * @Package chapter3.pojo
 * @Description: TODO
 * @date Date : 2019-02-18 23:49
 */


@Component
public class BussinessPerson implements Person,
        // 下面为研究生命周期而添加
        BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    // 根据property的type自己寻找注入
    @Autowired(required = true)
    // private Animal animal = null;  // 存在多个Animal对象装配会报错
    // 利用变量名称辨别歧义
    // @Qualifier("cat")  // 指定特定类来装配消除歧义
    private Animal dog = null;

    @Override
    public void service() {
        this.dog.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.dog = animal;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("[" + this.getClass().getSimpleName() + "] 调用BeanNameAware的setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("[" + this.getClass().getSimpleName() + "] 调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("[" + this.getClass().getSimpleName() + "] 调用ApplicationContextAware的setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[" + this.getClass().getSimpleName() + "] 调用InitializingBean的afterPropertiesSet");
    }

    @PostConstruct
    public void init() {
        System.out.println("[" + this.getClass().getSimpleName() + "] 调用InitializingBean的init");
    }

    @PreDestroy
    public void destroyl() {
        System.out.println("[" + this.getClass().getSimpleName() + "] 调用@PreDestroy自定义销毁的方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[" + this.getClass().getSimpleName() + "] 调用DisposableBean销毁的方法");
    }

}
