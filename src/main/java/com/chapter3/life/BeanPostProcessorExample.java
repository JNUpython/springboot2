package com.chapter3.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter3.life
 * @Description: TODO
 * @date Date : 2019-02-24 15:48
 */

public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization (Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor 调解"
        + "postProcessBeforeInitialization 方法 和 参数 【"
        + bean.getClass().getSimpleName() + "】【"
        + beanName + "】");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization (Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor 调解"
                + "postProcessAfterInitialization 方法 和 参数 【"
                + bean.getClass().getSimpleName() + "】【"
                + beanName + "】");
        return bean;
    }
}
