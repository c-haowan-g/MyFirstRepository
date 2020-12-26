/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core;

import org.hibernate.dialect.Oracle10gDialect;

/**
 * 为了配合RockWell系统的Oracle数据库，重写Hibernate获取ID的方法
 * @author Goofy
 * @Date 2018年6月14日 下午4:14:51
 */
public class RockWellOracleDialect extends Oracle10gDialect {

	/**
	 * GET_SEQUENCE_NUMBER 是一个自定义函数，定义如下：
	 
		  	CREATE OR REPLACE 
			FUNCTION GET_SEQUENCE_NUMBER RETURN NUMBER
			IS 
			PRAGMA AUTONOMOUS_TRANSACTION;
			SEQ_NUM NUMBER;
			UPDATED_ROWS NUMBER;
			BEGIN
				-- 循环，重新获取ID
				<<repeat>>
				SELECT SEQUENCE_NUMBER INTO SEQ_NUM FROM DATASWEEP_SEQUENCE WHERE SEQ_NUM_ID=2;
				-- 执行ID累加更新操作
				UPDATE DATASWEEP_SEQUENCE SET SEQUENCE_NUMBER=SEQUENCE_NUMBER+1 WHERE SEQ_NUM_ID=2 AND SEQUENCE_NUMBER=SEQ_NUM;
				UPDATED_ROWS:=SQL%ROWCOUNT;
				-- 如果更新行数为0，那么说明失败，需要重新获取,跳转到repeat
				IF UPDATED_ROWS=0 then 
					GOTO repeat;
				END IF;
				COMMIT;
				RETURN SEQ_NUM+1;
			END GET_SEQUENCE_NUMBER;

	 */
	@Override
	public String getSequenceNextValString(String sequenceName) {
		return "select GET_SEQUENCE_NUMBER() from dual";
	}

	
}
