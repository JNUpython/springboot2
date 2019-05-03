package com.chapter4.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter4.invoke
 * @Description: TODO
 * @date Date : 2019-02-24 22:47
 */

public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object target, Method method, Object[] params) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    /**
     *  以反射的方法调用原有的方法
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }
}
