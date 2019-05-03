package com.chapter4.intercept;

import com.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter4.service
 * @Description: TODO
 * @date Date : 2019-02-24 22:39
 */

public interface Interceptor {
    /**
     * 事前方法
     * @return
     */
    public boolean before();

    /**
     * 事后方法
     */
    public void after();

    /**
     * 取代原有事件方法，
     * @param invocation 回调参数 回调原有事件
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object around(Invocation invocation) throws
            InvocationTargetException, IllegalAccessException;

    /**
     * 没有发生异常的事后返回方法
     */
    public void afterReturning();

    /**
     * 事后异常方法，当发生异常事后执行
     */
    public void afterThrowing();

    /**
     * 是否使用around方法替代原有方法
     * @return
     */
    public boolean useAround();
}
