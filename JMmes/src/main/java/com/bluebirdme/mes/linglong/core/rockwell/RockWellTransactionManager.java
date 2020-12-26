/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.rockwell;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ibm.icu.text.SimpleDateFormat;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * 
 * @author Goofy
 * @Date 2018年8月22日 下午4:50:47
 */
@Aspect
@Component
public class RockWellTransactionManager {

	ThreadLocal<UserTransaction> trans = new ThreadLocal<UserTransaction>();
	Logger log=Logger.getLogger("RockWell事务管理器");

	@Pointcut("@annotation(com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional)")
	public void point() {
	}

	@Before("point()")
	public void before(JoinPoint joinPoint) {
		String act = "获取";
		if (trans.get() == null) {
			try {
				trans.set(RockWellUtils.getUserTransaction());
				log(act);
				act = "开启";
				try {
					trans.get().begin();
					log(act);
				} catch (Exception e) {
					log(act, e);
					throw e;
				}
			} catch (Exception e) {
				log(act, e);
				throw e;
			}
		}
	}

	@Around("point()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object ret=pjp.proceed();
		String act = "提交";
		if (trans.get() != null) {
			try {
				log("正在提交事务");
				trans.get().commit();
				log(act);
			} catch (Exception e) {
				trans.get().rollback();
				log(act, e);
				throw e;
			} finally {
				trans.remove();
			}
		}
		return ret;
	}

	@AfterThrowing("point()")
	public void afterThrowing(JoinPoint joinPoint) {
		String act = "回滚";
		if (trans.get() != null) {
			try {
				trans.get().rollback();
				log(act);
			} catch (Exception e) {
				log(act, e);
				throw e;
			} finally {
				trans.remove();
			}
		}
	}

	public void log(String action) {
		action = "线程ID." + Thread.currentThread().getId() + "\t" + action + ".成功\t";
		log.info(action);

	}

	public void log(String action, Exception ex) {
		action = "线程ID " + Thread.currentThread().getId() + "\t< " + action + " > 失败\t异常信息<<" + ex.getLocalizedMessage() + ">>";
		log.info(action);
	}

}
