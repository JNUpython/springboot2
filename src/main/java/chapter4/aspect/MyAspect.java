package chapter4.aspect;


import chapter3.pojo.User;
import chapter4.aspect.validator.UserValidator;
import chapter4.aspect.validator.impl.UserValidatorImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @author : kean
 * @version V1.0
 * @Project: springboot2
 * @Package chapter4.aspect
 * @Description: TODO
 * @date Date : 2019-03-04 23:00
 */

// @Aspect
// public class MyAspect {
//
//     @Before("execution(* chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
//     public void before() {
//         System.out.println("before printUser ...");
//     }
//
//     @After("execution(* chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
//     public void after() {
//         System.out.println("after printUser ...");
//     }
//
//     @AfterReturning("execution(* chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
//     public void afterReturning() {
//         System.out.println("afterReturning printUser ...");
//     }
//
//     @AfterThrowing("execution(* chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
//     public void afterThrowing() {
//         System.out.println("afterThrowing printUser ...");
//     }
//
// }

@Aspect
@Slf4j
@Order(1)  // 多个切面指定顺序
public class MyAspect {

    // @DeclareParents(value= "chapter4.aspect.service.impl.UserServiceImpl+", defaultImpl= UserValidatorImpl.class)
    // public UserValidator userValidator;

    @Pointcut("execution(* chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        System.out.println("before printUser ...");
    }

    /**
     * 给通知传递参数
     * @param user
     */
    @Before("pointCut() && args(user)")  // 将连接点为user的对象传递进来
    public void beforeParam(JoinPoint point, User user) {  // JoinPoint 对应非环绕，ProceedingJointPoint 对应环绕对象
        Object[] args = point.getArgs(); // 获取所有参数
        log.info("{}", args);
        System.out.println("before ......" + user.getUserName());
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after printUser ...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning printUser ...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing printUser ...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        // 尽量不使用
        System.out.println("around before......");
        jp.proceed();
        System.out.println("around after......");
    }

}
