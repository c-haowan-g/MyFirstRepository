/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.devtools.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.devtools.entity.Col;
import com.bluebirdme.mes.linglong.devtools.entity.Tbl;

/**
 * 
 * @author Goofy
 * @Date 2018年6月27日 下午2:25:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DbServiceImpl extends RockWellBaseServiceImpl {

	@Resource
	LingLongDataSource llds;

	/**
	 * 获取用户新建的所有表
	 * 
	 * @author Goofy
	 * @Date 2018年6月27日 下午3:09:13
	 * @return
	 * @throws Exception
	 */
	public List<Tbl> getTables() throws Exception {
		String sql = "select a.name,b.description memo from (SELECT upper(table_name) name FROM user_tables where TABLESPACE_NAME is not null　and table_name not like 'AA_%' and  user='MES' or user='JMMES'  order by table_name asc ) a left join (select concat('AT_',upper(at_name)) name,description from app_table order by name asc) b on a.name=b.name";
		return createSQLQuery(sql, Tbl.class).list();
	}

	public List<Col> getColumns(String tblName) throws Exception {
		String tblName2 = "";
		if (tblName.contains("AT_")) {
			if (tblName.startsWith("AT_")) {
				tblName2 = tblName.substring(3);
			}
			String sql = "	SELECT "
					+ "		ATC.ATC_NAME name, "
					+ "		ATC.ATC_DATATYPE type,"
					+ "		ATC.TEXT_LENGTH dataLength,"
					+ "		(case ATC.IS_NULLABLE when 1 then 'true' else 'false' end) as nullable,"
					+ "		case when ATC.DESCRIPTION is null then Translate('无注释' USING NCHAR_CS) else ATC.DESCRIPTION end memo,"
					+ "		0	precision," + "		'0' db_name" + "	FROM " + "		APP_TABLE T "
					+ "	LEFT JOIN APP_TABLE_COLUMN atc ON ATC.AT_KEY = T .AT_KEY " + "	WHERE "
					+ "		upper(T.AT_NAME) = upper('" + tblName2 + "') ";
			// System.out.println(sql);
			return createSQLQuery(sql, Col.class).list();
		} else {
			String sql = " SELECT UDA.NAME, "
					+ "		UDA.TYPE, "
					+ "		'0' AS nullable, "
					+ "		UDA.TEXT_LENGTH AS dataLength, "
					+ "		'0' AS precision, "
					+ "        UDA.DB_NAME,     "
					+ "	  case when UDA.DESCRIPTION is null then Translate('无注释' USING NCHAR_CS) else UDA.DESCRIPTION end memo "
					+ "	FROM UDA,( " + "		SELECT C.CLASS_NAME FROM CLASS_TABLE_MAP C "
					+ "		WHERE DB_TABLE_NAME = upper('" + tblName + "')  " + "	)TD WHERE OBJECT_TYPE=TD.CLASS_NAME ";
			System.out.println(sql);
			return createSQLQuery(sql, Col.class).list();
		}

	}

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@Override
	protected Class getEntity() {
		return null;
	}

}
