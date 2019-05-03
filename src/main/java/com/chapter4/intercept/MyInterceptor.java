package com.chapter4.intercept;

import com.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter4.intercept
 * @Description: TODO
 * @date Date : 2019-02-24 22:55
 */

/**
 * 自定义的拦截接口
 */
public class MyInterceptor implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("before ...");
        return true;
    }

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ... ");
    }

    @Override
    public Object around(Invocation invocation) throws
            InvocationTargetException, IllegalAccessException {
        System.out.println("around before ...");
        Object object = invocation.proceed();
        System.out.println("around after ...");
        return object;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning ...");
    }

    @Override
    public void afterThrowing () {
        System.out.println("afterThrowing ...");
    }
}
