package chapter4;

import chapter4.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter4
 * @Description: TODO
 * @date Date : 2019-03-04 23:42
 */

@SpringBootApplication(scanBasePackages = "chapter4.aspect")
public class Chapter4Application {

    /**
     * 定义切面
     * @return
     */
    @Bean(name="myAspect")
    public MyAspect initMyaspect() {
        return new MyAspect();
    }

    /**
     * 启动切面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class, args);
    }
}
