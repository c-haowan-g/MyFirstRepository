/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.dto.UdaDto;
import com.bluebirdme.mes.linglong.curing.uda.ProductionLineUDA;
import com.bluebirdme.mes.linglong.util.DateUtil;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.datasweep.compatibility.client.Area;
import com.datasweep.compatibility.client.ProductionLine;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 硫化机台信息管理
 * @author 司乔靖
 * @Date 2019-07-13 09:55:26
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CuringProductionLineInfoServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
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
	
	public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
	
    @RockWellTransactional
    public int saveChanges(UdaDto udadto) throws Exception{
        
    	int num = 0;
        if (!ListUtils.isEmpty(udadto.getDeleted())) {
        	List<Map<String, Object>> listMap=udadto.getDeleted();
	        for(Map<String, Object> item:listMap){
	        	if(item.get("p_line_name") !=null){	        		
	        		ProductionLine productionLine = getFunction().getProductionLineByName(item.get("p_line_name").toString());
	                if(productionLine == null){
	                	//3表示该产线已经被删除
	                	num=3;
	            	}else{
	            		String areaCode = FactoryConstant.JING_MEN_CODE+LLWebUtils.factory()+"C";
	            		Area area = getFunction().getAreaByName(areaCode);
	            		area.removeProductionLine(productionLine);
	            		area.Save(getFunction().getDBTime(), "update a record:" + areaCode, null);
	            		productionLine.delete(new Time(),"p_line_name");
	            		//操作成功
	            		num=1;
	            	}
            	}
	        }
        }
        if (!ListUtils.isEmpty(udadto.getInserted())) {
        	List<Map<String, Object>> listMap=udadto.getInserted();
            for(Map<String, Object> item:listMap){
            	if(item.get("p_line_name") !=null){
					ProductionLine productionLine = getFunction().getProductionLineByName(item.get("p_line_name").toString());
					System.out.println(item.get("p_line_name").toString());
					if(productionLine == null){
						String areaCode = FactoryConstant.JING_MEN_CODE+LLWebUtils.factory()+"C";
						Area area = getFunction().getAreaByName(areaCode);
		        		productionLine = getFunction().createProductionLine((String) item.get("p_line_name"));
		             	//默认参数
		             	productionLine.setUDA(WebUtils.getUser().userCode, ProductionLineUDA.CREATEBY);
		             	Date date = new Date();
						Timestamp timestamp = DateUtil.dateToTime(date);
		             	productionLine.setUDA(timestamp, ProductionLineUDA.CREATETIME);
		             	productionLine.setUDA(LLWebUtils.factory(), ProductionLineUDA.S_FACTORY);
		             	productionLine.setUDA(FactoryConstant.JING_MEN_CODE, ProductionLineUDA.AGENCNO);
		             	//自定义参数
		             	productionLine.setCategory((String)item.get("category"));
		             	productionLine.setDescription((String)item.get("description"));
		             	productionLine.setUDA((String) item.get("machinegroup_s"), ProductionLineUDA.MACHINEGROUP);
		             	productionLine.setUDA((String) item.get("status_s"), ProductionLineUDA.STATUS);
		             	System.out.println(item.get("ip_s"));
		             	productionLine.setUDA((String) item.get("ip_s"), ProductionLineUDA.IP_S);
		             	//productionLine.save();
		             	productionLine.Save(getFunction().getDBTime(), "update a record:" + item.get("p_line_name").toString(), null);
		             	area.addProductionLine(productionLine);
		             	area.Save(getFunction().getDBTime(), "update a record:" + areaCode, null);
		             	//操作成功
		             	num=1;
	            	 }else{
	            		//2表示代码重复
	            		num=3;
	            	 }
            	 }
             }
        }
        if (!ListUtils.isEmpty(udadto.getUpdated())) {
            List<Map<String, Object>> listMap=udadto.getUpdated();
            for(Map<String, Object> item:listMap){
            	if(item.get("p_line_name") !=null){
           		ProductionLine productionLine = getFunction().getProductionLineByName(item.get("p_line_name").toString());
	                if(productionLine != null){
	                	//productionLine = getFunction().createProductionLine((String) item.get("p_line_name"));
	                    //默认参数
	                    productionLine.setUDA(WebUtils.getUser().userCode, ProductionLineUDA.CHANGEBY);
	                    Date date = new Date();
	        			Timestamp timestamp = DateUtil.dateToTime(date);
	                    productionLine.setUDA(timestamp, ProductionLineUDA.CHANGETIME);
	                    //productionLine.setUDA(LLWebUtils.factory(), ProductionLineUDA.S_FACTORY);
	                    //productionLine.setUDA(FactoryConstant.LIU_ZHOU_CODE, ProductionLineUDA.AGENCNO);
	                    //自定义参数
	                    productionLine.setCategory((String)item.get("category"));
	                    productionLine.setDescription((String)item.get("description"));
	                    productionLine.setUDA((String) item.get("machinegroup_s"), ProductionLineUDA.MACHINEGROUP);
	                    productionLine.setUDA((String) item.get("status_s"), ProductionLineUDA.STATUS);
	                    productionLine.setUDA((String) item.get("ip_s"), ProductionLineUDA.IP_S);
	                    //productionLine.save();
	                    productionLine.Save(getFunction().getDBTime(), "update a record:" + item.get("p_line_name").toString(), null);
	                    num=1;
	            	}else{
	            		//3表示该产线已经被删除
	            		num=3;
	            	}
            	}
            }
        }     
    	return num;
    }

    /**
	 * 载具条码重复性校验
	 * 
	 * @return
	 */
	public int checkPLineName(String plinename,String plinekey) {
		SQLQuery query = createSQLQuery(getSQL("pLineName_Query"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("p_line_name", plinename);
		int plinekey2;
		if(!(plinekey.equals(""))){
			plinekey2=Integer.parseInt(plinekey);
		}else{
			plinekey2=0;
		}
		query.setParameter("p_line_key", plinekey2);
		List arr = query.list();
		if(arr.size()==0){
			return 1;
		}
		return 0;
	}
	
	   /**
		 * 
		 * @Title: getProductlineEqu
		 * @Description: TODO(硫化产线下拉框)
		 * @return: List<Map<String,Object>> 返回类型
		 * 
		 */
		public List<Map<String, Object>> getProductlineEqu(String factory) throws Exception {
			SQLQuery query = createSQLQuery(getSQL("comboxProductlineEqu"));
			query.setParameter("sitename", factory);
			query.setParameter("process_s", "252006");//工序
			List<Map<String, Object>> list = query.list();
			return list;
		}
}
