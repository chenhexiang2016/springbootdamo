package com.study.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

//    @Pointcut("execution( * com.study..controller.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    @Pointcut("execution( * com.study.demo.service..*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut() {
    }


    @Before("logPointCut()")
    public void log(){
        //logger.info("before method log done"+ AopContext.currentProxy().getClass());
        logger.info("before method log done");
    }

    //可以通过JoinPoint取到aop的类名，方法参数，方法签名
    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        logger.info("after method log done "+joinPoint.getTarget().getClass()+",args="+ Arrays.asList(joinPoint.getArgs())+",method="+joinPoint.getSignature());
    }
}
