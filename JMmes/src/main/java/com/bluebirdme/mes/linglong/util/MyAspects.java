package com.bluebirdme.mes.linglong.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Aspect
@Component
/**
 * 
 * @author 周清玉
 *	2019-09-09
 *	方法日志 ，让控制台显示更清晰
 */
public class MyAspects {
	/*** 前置通知：目标方法执行之前执行以下方法体的内容      * @param jp     */
	@Before(" execution(* com.bluebirdme.mes.linglong.curing.service.*.*(..))") 
	
	public void beforeMethod(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		System.out.println("【前置通知】方法名 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
	}
	
	/**     * 返回通知：目标方法正常执行完毕时执行以下代码     * @param jp     * @param result     */
	@AfterReturning(value="execution(* com.bluebirdme.mes.linglong.curing.service.*.*(..))",returning="result")
	public void afterReturningMethod(JoinPoint jp, Object result){
		String methodName = jp.getSignature().getName();
		System.out.println("【返回通知】方法名 【" + methodName + "】 ends with 【" + result + "】");
	}
	/**     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。     * @param jp     
	@After("execution(* com.bluebirdme.mes.linglong.curing.service.*.*(..))")
	public void afterMethod(JoinPoint jp){
		System.out.println("【后置通知】this is a afterMethod advice...");
	}*/
	
	/**     * 异常通知：目标方法发生异常的时候执行以下代码     */
	@AfterThrowing(value="execution(* com.bluebirdme.mes.linglong.curing.service.*.*(..))",throwing="e")
	public void afterThorwingMethod(JoinPoint jp, NullPointerException e){
		String methodName = jp.getSignature().getName();
		System.out.println("【异常通知】方法名【" + methodName + "】 occurs exception: " + e);
	}
}
