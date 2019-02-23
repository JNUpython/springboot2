package chapter3.pojo;

import chapter3.pojo.definition.Animal;
import chapter3.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
