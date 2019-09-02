package com.unicom.girl.aspect;

import com.unicom.girl.controller.GirlController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/9/1 21:10 <br/>
 * @Author: yangjiabin
 */
@Aspect//切面注释
@Component//让spring进行管理
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.unicom.girl.controller.GirlController.*(..))")
    public void log(){

    }

    //@Before("execution(public * com.unicom.girl.controller.GirlController.girlList(..))")
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //System.out.println(11111);
        logger.info("11111");

        //url

        //method


        //ip

        //类方法

        //参数


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        //System.out.println(22222);
        logger.info("222222");
    }


    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){

        logger.info("response={}",object.toString());
    }



}
