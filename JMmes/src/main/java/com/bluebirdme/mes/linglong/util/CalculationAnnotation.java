package com.bluebirdme.mes.linglong.util;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculationAnnotation {

	  @Before("execution(* com.bluebirdme.mes.linglong.util.CalculationImpl.add(..))")
	    public void before(JoinPoint join){
	        //获取方法名
	        String mathName=join.getSignature().getName();
	        //获取参数列表
	        List<Object> args = Arrays.asList(join.getArgs());
	        
	        System.out.println("前置通知---->before   方法名是:"+mathName+"\t参数列表是:"+args);
	    }
}
