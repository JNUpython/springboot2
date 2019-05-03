package com.chapter4;

import com.chapter4.intercept.MyInterceptor;
import com.chapter4.proxy.ProxyBean;
import com.chapter4.service.HelloService;
import com.chapter4.service.impl.HelloServiceImpl;
import org.junit.Test;


/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter4
 * @Description: TODO
 * @date Date : 2019-02-24 23:15
 */

public class MyInterceptorTest {

    @Test
    public void test() {
        HelloService helloService = new HelloServiceImpl();
        // 按约定获取代理
        HelloService proxy = (HelloService) ProxyBean.getBeanFactory(helloService, new MyInterceptor());
        proxy.sayHello("kean");
        System.out.println("\n############### name is null #################\n");
        proxy.sayHello(null);
    }
}
