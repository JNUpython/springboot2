package chapter3.pojo;

import chapter3.pojo.definition.Animal;
import chapter3.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author : kean
 * @version V1.0
 * @Project: learnSpingBoot
 * @Package chapter3.pojo
 * @Description: TODO
 * @date Date : 2019-02-18 23:49
 */


@Component
public class BussinessPerson implements Person {

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
        this.dog = animal;
    }
}
