package com.chapter4.proxy;

import com.chapter4.intercept.Interceptor;
import com.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package com.chapter4.proxy
 * @Description: TODO
 * @date Date : 2019-02-24 23:25
 */

public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;


    /**
     * 绑定代理对象
     * @param target 被代理对象
     * @param interceptor 拦截器
     * @return 代理对象
     */
    public static Object getBeanFactory(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        // 被保存代理对象
        proxyBean.target = target;

        // 保存拦截器
        proxyBean.interceptor = interceptor;

        // 生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);

        // 返回代理对象
        return proxy;
    }

    /**
     * 处理代理对象 方法逻辑
     * @param proxy  代理对象
     * @param method 当前方法
     * @param args 运行参数
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target, method, args);
        Object retObj = null;
        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Exception ex) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag) {
            interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
