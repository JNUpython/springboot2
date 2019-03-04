package chapter4.aspect;


import org.aspectj.lang.annotation.*;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter4.aspect
 * @Description: TODO
 * @date Date : 2019-03-04 23:00
 */

@Aspect
public class MyAspect {

    @Before("execution(* chapter4.aspect.service.UserServiceImpl.printUser(..))")
    public void before() {
        System.out.println("before printUser ...");
    }

    @After("execution(* chapter4.aspect.service.UserServiceImpl.printUser(..))")
    public void after() {
        System.out.println("after printUser ...");
    }

    @AfterReturning("execution(* chapter4.aspect.service.UserServiceImpl.printUser(..))")
    public void afterReturning() {
        System.out.println("afterReturning printUser ...");
    }

    @AfterThrowing("execution(* chapter4.aspect.service.UserServiceImpl.printUser(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing printUser ...");
    }

}
