
package com.github.alan2lin.runtime.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/20 12:36
 * @Version V1.0
 */
@Aspect
@Slf4j
@Component
public class FrameworkLogAspect {

    //framework 初始化的过程的tracing
    //TODO: aop的切点无效， 原因待查
    //@Pointcut("execution(* com.alan2lin.runtime.intf.FsmFramework.*(..))")
    //@Pointcut("execution(* com.alan2lin..*.*(..)) || execution(* com.alan2lin.runtime.intf.FsmFramework.start())")
    @Pointcut("execution(* com.alan2lin..*.*(..))")
    public void startUpLog(){}

    @Before("startUpLog()")
    public void startUpLogBefore(JoinPoint joinPoint){
        log.info("### Before CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @After("startUpLog()")
    public void startUpLogAfter(JoinPoint joinPoint){
        log.info("### After CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

}
