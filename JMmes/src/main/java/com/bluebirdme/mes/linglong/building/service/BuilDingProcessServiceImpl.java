/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.entity.BuilDingProcess;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;


/**
 * 成型工艺参数配方查询
 * @author 周清玉
 * @Date 2019-08-15 08:40:14
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BuilDingProcessServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return BuilDingProcess.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    public List<Map<String, Object>> searchByMaterial(String key) {
		SQLQuery parameterQuery = createSQLQuery(getSQL("curingparameterm"));
		parameterQuery.setParameter("key", key);
		parameterQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> parameterList= parameterQuery.list();
		SQLQuery toleranceQuery = createSQLQuery(getSQL("toleranceparam"));
		List<Map<String, Object>> toleranceList= toleranceQuery.list();
		List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();
		Map<String,Object> resultMap=null;
		for(int i=0;i<parameterList.size();i++){
			resultMap=new HashMap<String,Object>();
			resultMap=parameterList.get(i);
			for(int j=0;j<toleranceList.size();j++){
				if(parameterList.get(i).get("PARMCODE_S").equals(toleranceList.get(j).get("PARMCODE_S"))&&parameterList.get(i).get("VALUE_S")!=null){
					System.out.println(parameterList.get(i).toString());
					System.out.println(toleranceList.get(j).toString());
					Float valuemax=changeNum(parameterList.get(i).get("VALUE_S").toString(),toleranceList.get(j).get("VALUEMAX_S").toString());
					Float valuemin=changeNum(parameterList.get(i).get("VALUE_S").toString(),toleranceList.get(j).get("VALUEMIN_S").toString());
					if(parameterList.get(i).get("VALUE_S").toString().contains("°")){
						resultMap.put("VALUEMAX_S",valuemax+"°");
						resultMap.put("VALUEMIN_S",valuemin+"°");
						break;//跳出内层循环，否则最后一次数据会一直覆盖
					}else{
						resultMap.put("VALUEMAX_S",valuemax);
						resultMap.put("VALUEMIN_S",valuemin);
						break;//跳出内层循环，否则最后一次数据会一直覆盖
					}
				}else{
					resultMap.put("VALUEMAX_S", "");
					resultMap.put("VALUEMIN_S", "");
				}
			}
			resultMapList.add(resultMap);
		}
		return resultMapList;
	}
    /**
     * whl 修改半钢出现最小公差是0，因此需修改 2020/02/10
     * @param value
     * @param num
     * @return
     */
    public Float changeNum(String value,String num){
    	String operator=num.substring(0, 1);
    	BigDecimal A =null;
    	BigDecimal B =null;
    	if(!"0".equals(operator)){
    		int index=num.length();
    		String waitChangeNum=num.substring(1, index);
    		if(value.contains("°")){
    			value=value.substring(0,value.length()-1);
    		}
    		A = new BigDecimal(value);//工艺参数值
    		B = new BigDecimal(waitChangeNum);//公差参数带运算的值
    	}else{
    		A = new BigDecimal(value);//工艺参数值
    	}
    	switch (operator) {
		case "+":
			return A.add(B).floatValue();
		case "-":
			return A.subtract(B).floatValue();
		case "*":
			return A.multiply(B).floatValue();
		case "/":
			return A.divide(B).floatValue();
		case "0":
    		return A.floatValue();
		}
    	return null;
    }
    
    public Map<String, Object> datagridUDA_Ping(Filter filter, Page page) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}
    
    @SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		List<String> QGParaLists=new ArrayList<>();
    	List<String> BGParaLists=new ArrayList<>();
		if(LLWebUtils.factory().equals("1")){
    		QGParaLists.add("H2");
    		query.setParameterList("dictcode_s", QGParaLists);
    	}else if(LLWebUtils.factory().equals("2")){
    		BGParaLists.add("H1");
    		BGParaLists.add("H3");
    		query.setParameterList("dictcode_s", BGParaLists);
    	}
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			List<String> QGParaLists=new ArrayList<>();
	    	List<String> BGParaLists=new ArrayList<>();
			if(LLWebUtils.factory().equals("1")){
	    		QGParaLists.add("H2");
	    		query.setParameterList("dictcode_s", QGParaLists);
	    	}else if(LLWebUtils.factory().equals("2")){
	    		BGParaLists.add("H1");
	    		BGParaLists.add("H3");
	    		query.setParameterList("dictcode_s", BGParaLists);
	    	}
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
    /**
	 * 获取色标线对应关系
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getColorMarkingLine()
			throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getColorMarkingLine"));
		return query.list();
	}
}
