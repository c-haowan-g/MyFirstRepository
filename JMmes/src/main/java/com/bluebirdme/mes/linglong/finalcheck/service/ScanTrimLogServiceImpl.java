/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ecs.xhtml.br;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanTrimLog;
import com.lhqx.PIReturnObject;
import com.lhqx.WSImplement;
import com.lhqx.WSInterface;

/**
 * 割毛产量查询
 * @author 时永良
 * @Date 2018-08-04 18:14:57
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ScanTrimLogServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ScanTrimLog.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    public List<Map<String, Object>> search(Map<String, Object> map){
		// 查询开始时间
		String startdate_t = map.get("begin_created_time").toString().replace("-", "");
		startdate_t = startdate_t.toString().replace(" ", "");
		startdate_t = startdate_t.toString().replace(":", "");
		// 查询结束时间
		String enddate_t = map.get("begin_created_time").toString().replace("-", "");
		enddate_t = enddate_t.toString().replace(" ", "");
		enddate_t = enddate_t.toString().replace(":", "");
		//class_id_s1故意写错，要不进不去此页面
		String shift=map.get("class_id_s1").toString();
		if(shift!=null||shift!=""){
			if(shift=="302001"){
				startdate_t="";
				enddate_t="";
			}else if(shift=="302002"){
				startdate_t="";
				enddate_t="";
			}else if(shift=="302003"){
				startdate_t="";
				enddate_t="";
			}
			
		}
		
		
    	PIReturnObject gm1value;//存储取到割毛机1号的数据
    	PIReturnObject gm2value;//存储取到割毛机2号的数据
    	PIReturnObject gm3value;//存储取到割毛机3号的数据
    	PIReturnObject gm4value;//存储取到割毛机4号的数据
    	PIReturnObject gm5value;//存储取到割毛机5号的数据
    	PIReturnObject gm6value;//存储取到割毛机6号的数据
    	PIReturnObject gm7value;//存储取到割毛机7号的数据
    	PIReturnObject gm8value;//存储取到割毛机8号的数据
    	WSImplement service = new WSImplement();
    	WSInterface portType = service.getBasicHttpBindingWSInterface();
    	
    	//String factoryString=LLWebUtils.factory();
    	String factoryString="2";//暂时写死
    	//半钢
    	if(factoryString.endsWith("2")){
	    	gm1value = portType.queryRealData("9GM01", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_1#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm2value = portType.queryRealData("9GM02", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_2#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm3value = portType.queryRealData("9GM03", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_3#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm4value = portType.queryRealData("9GM04", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_4#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm5value = portType.queryRealData("9GM05", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_5#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm6value = portType.queryRealData("9GM06", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_6#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm7value = portType.queryRealData("9GM07", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_7#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm8value = portType.queryRealData("9GM08", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_8#TireNum", startdate_t, enddate_t);// 获取数据
    	}else{
    		//全纲； 以后更改机台与地址
    		gm1value = portType.queryRealData("9GM01", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_1#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm2value = portType.queryRealData("9GM02", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_2#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm3value = portType.queryRealData("9GM03", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_3#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm4value = portType.queryRealData("9GM04", "BGSCADA:BGOPC12:WGQFJ_JC1.WGQFJ_JC1.GM1.PLCTOMES_4#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm5value = portType.queryRealData("9GM05", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_5#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm6value = portType.queryRealData("9GM06", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_6#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm7value = portType.queryRealData("9GM07", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_7#TireNum", startdate_t, enddate_t);// 获取数据
	    	gm8value = portType.queryRealData("9GM08", "BGSCADA:BGOPC12:WGQFJ_JC2.WGQFJ_JC2.GM2.PLCTOMES_8#TireNum", startdate_t, enddate_t);// 获取数据

    	}
    	List<Object> bb1 = gm1value.getRPidata().getAnyType();
    	List<Object> bb2 = gm2value.getRPidata().getAnyType();
    	List<Object> bb3 = gm3value.getRPidata().getAnyType();
    	List<Object> bb4 = gm4value.getRPidata().getAnyType();
    	List<Object> bb5 = gm5value.getRPidata().getAnyType();
    	List<Object> bb6 = gm6value.getRPidata().getAnyType();
    	List<Object> bb7 = gm7value.getRPidata().getAnyType();
    	List<Object> bb8 = gm8value.getRPidata().getAnyType();
    	//先算不跨班的
    	
    	SQLQuery query=createSQLQuery(getSQL("getEntCode"));
    	query.setParameter("s_factory_s", factoryString);
    	//query.setParameter("s_factory_s", LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
        	
    	double min1Value=Double.parseDouble(new StringBuilder(bb1.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max1Value=Double.parseDouble(new StringBuilder(bb1.get(bb1.size()-1).toString().split(":")[1].substring(0)).toString());
    	double min2Value=Double.parseDouble(new StringBuilder(bb2.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max2Value=Double.parseDouble(new StringBuilder(bb2.get(bb2.size()-1).toString().split(":")[1].substring(0)).toString());
    	double min3Value=Double.parseDouble(new StringBuilder(bb3.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max3Value=Double.parseDouble(new StringBuilder(bb3.get(bb3.size()-1).toString().split(":")[1].substring(0)).toString());
    	double min4Value=Double.parseDouble(new StringBuilder(bb4.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max4Value=Double.parseDouble(new StringBuilder(bb4.get(bb4.size()-1).toString().split(":")[1].substring(0)).toString());
    	double min5Value=Double.parseDouble(new StringBuilder(bb5.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max5Value=Double.parseDouble(new StringBuilder(bb5.get(bb5.size()-1).toString().split(":")[1].substring(0)).toString());
    	double min6Value=Double.parseDouble(new StringBuilder(bb6.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max6Value=Double.parseDouble(new StringBuilder(bb6.get(bb6.size()-1).toString().split(":")[1].substring(0)).toString());
    	double min7Value=Double.parseDouble(new StringBuilder(bb7.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max7Value=Double.parseDouble(new StringBuilder(bb7.get(bb7.size()-1).toString().split(":")[1].substring(0)).toString());
    	double min8Value=Double.parseDouble(new StringBuilder(bb8.get(0).toString().split(":")[1].substring(0)).toString());// 取最小值
    	double max8Value=Double.parseDouble(new StringBuilder(bb8.get(bb8.size()-1).toString().split(":")[1].substring(0)).toString());
    	int max=list.size();
    	List<Map<String, Object>> arrayList=new ArrayList<Map<String, Object>>();
    	if(list!=null){
    		for(int i=0;i<max;i++){
				String equipcode =list.get(i).get("EQUIP_NAME").toString();
				Map<String, Object> res = new HashMap<String, Object>();
				switch(equipcode){
				case "9GM01":
					res.put("gmcl", max1Value-min1Value);
					break;
				case "9GM02":
					res.put("gmcl", max2Value-min2Value);
					break;
				case "9GM03":
					res.put("gmcl", max3Value-min3Value);
					break;
				case "9GM04":
					res.put("gmcl", max4Value-min4Value);
					break;
				case "9GM05":
					res.put("gmcl", max5Value-min5Value);
					break;
				case "9GM06":
					res.put("gmcl", max6Value-min6Value);
					break;
				case "9GM07":
					res.put("gmcl", max7Value-min7Value);
					break;
				case "9GM08":
					res.put("gmcl", max8Value-min8Value);
					break;
				}
				res.put("machinebar_s", list.get(i).get("EQUIP_NAME").toString());
				/*res.put("created_by_s", list.get(i).get("CREATED_BY_S").toString());
				res.put("created_time_t", list.get(i).get("CREATED_TIME_T").toString());*/
				arrayList.add(res);
	    	}
    	}
    	return arrayList;
    }

}
