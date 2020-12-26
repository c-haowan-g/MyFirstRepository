/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.building.entity.GreenTireCodePrestore;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 胎胚条码预存表
 * @author 兰颖慧
 * @Date 2019-03-06 12:45:58
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class GreenTireCodePrestoreServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
	private boolean tip;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return GreenTireCodePrestore.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public String saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
            if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
    			List<Map<String, Object>> GreenTireCodeList = rockWellEntityDTO.getInserted();
    			List<Object> GreenTireCodePrestores=new ArrayList<>();//保存对象集合
                List<String> addString = new ArrayList<>();
    			List<String> result = new ArrayList<>();
                String newAddBarCode=null;
    			for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
    				GreenTireCodePrestore greenTireCode=(GreenTireCodePrestore)  MapTrunPojo.mapToEntity(GreenTireCodeList.get(i), getEntity());
    				greenTireCode.setCreated_by_s(LLWebUtils.getUser().userCode);   //自动添加创建人
    				greenTireCode.setCreated_time_t(new Date());                  //自动添加创建时间
    				greenTireCode.setRecord_flag_s("A"); 	                       //自动添加Record
    				greenTireCode.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
    				greenTireCode.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);   //自动添加机构代码-8023
    				greenTireCode.setStatus_s("01");                //自动添加胎胚条码状态
    				newAddBarCode=greenTireCode.getBarcode_s(); 	   //获取输入的胎胚条码
    				 if(LLWebUtils.factory().equals("1")){
    				    	if(!newAddBarCode.substring(0, 1).equals("F")||newAddBarCode.length()!=10){
    							result.add(newAddBarCode+"胎胚条码不符合编码规范");
    							continue;
    						}
    				 }else{
    				    	if(!newAddBarCode.substring(0, 1).equals("H")||newAddBarCode.length()!=10){
    							result.add(newAddBarCode+"胎胚条码不符合编码规范");
    							continue;
    						}
    				 }
    				/*根据 胎胚条码 进行查重*/
    				if (duplicationCheck(newAddBarCode) == true) //数据库内判重
    				{  
    					result.add(newAddBarCode+"胎胚车编码数据库内已存在");
    					continue;
    				}
    				if(addString.contains(newAddBarCode)) //界面新增行判重
    				{
    					result.add(newAddBarCode+"胎胚车编码重复添加");
    					continue;
    				}else{
    					addString.add(newAddBarCode); 
    					GreenTireCodePrestores.add(greenTireCode);
    				}
    			}
    			if(result.isEmpty()==true){
    				
    				save(GreenTireCodePrestores);
    				return "操作成功";
    			}
    			else{
    				return result.toString();
    			}
    		 }
            //删除行
            if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
            	List<Map<String, Object>> GreenTireCodeList = rockWellEntityDTO.getDeleted();
    			List<Object> GreenTireCodePrestores=new ArrayList<>();//保存对象集合
    			for (int i = 0; i < GreenTireCodeList.size(); i++) {
    				GreenTireCodePrestore greenTireCode=(GreenTireCodePrestore)  MapTrunPojo.mapToEntity(GreenTireCodeList.get(i), getEntity());
    				greenTireCode.setRecord_flag_s("D");
    				// 自动添加删除操作的时间
    				greenTireCode.setChanged_time_t(new Date());
    				GreenTireCodePrestores.add(greenTireCode);
    			}
    			update(GreenTireCodePrestores);
    			return "操作成功";
        }
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			List<Map<String, Object>> GreenTireCodeList =  rockWellEntityDTO.getUpdated();
			List<Object> GreenTireCodePrestores=new ArrayList<>();//保存对象集合
            List<String> addString = new ArrayList<>();
			List<String> result = new ArrayList<>();
            String updateBarCode=null;
			for (Map<String, Object> greenTireCode:GreenTireCodeList) {
				GreenTireCodePrestore item=(GreenTireCodePrestore)  MapTrunPojo.mapToEntity(greenTireCode, getEntity());
        		item.setChanged_by_s(LLWebUtils.getUser().userCode); //修改人
        		item.setChanged_time_t(new Date());  //修改时间
			    updateBarCode=item.getBarcode_s(); 	   //获取输入的胎胚条码
			    if(LLWebUtils.factory().equals("1")){
			    	if(!updateBarCode.substring(0, 1).equals("F")||updateBarCode.length()!=10){
						result.add(updateBarCode+"胎胚条码不符合编码规范");
						continue;
					}
			    }else{
			    	if(!updateBarCode.substring(0, 1).equals("H")||updateBarCode.length()!=10){
						result.add(updateBarCode+"胎胚条码不符合编码规范");
						continue;
					}
			    }
				
				/*根据 胎胚条码 进行查重*/
				if (duplicationCheck(updateBarCode) == true) //数据库内判重
				{  
					result.add(updateBarCode+"胎胚车编码数据库内已存在");
					continue;
				}
				if(addString.contains(updateBarCode)) //界面新增行判重
				{
					result.add(updateBarCode+"胎胚车编码重复添加");
					continue;
				}else{
					addString.add(updateBarCode); 
					GreenTireCodePrestores.add(item);
				}
			}
			if(result.isEmpty()==true){
				
				update(GreenTireCodePrestores);
				return "操作成功";
			}
			else{
				return result.toString();
			}
        }
        return "未执行任何操作";
    }
    public static String  addValue(String str){
       DecimalFormat countFormat = new DecimalFormat("000000000");
       return countFormat.format(Integer.parseInt(str)+1).toString();
    }
    /**
     * 校验批量数据维护是否正确//写的真傻子，用between多好，哈哈，不改了lcm
     * @param greenTireCode
     * @param batchNum
     * @author 刘程明
     * @date 2019年4月22日
     */
    StringBuffer batchAddResult = new StringBuffer();
    @SuppressWarnings("unchecked")
	public List<String> validBatchInfo(String greenTireCode,int batchNum) {
    	List<String> allowAddBarcodeList=new ArrayList<>();//允许添加的条码列表
		String preString=greenTireCode.substring(0,1);
		String lastString=greenTireCode.substring(1,greenTireCode.length());
		String newString=lastString;
	    StringBuffer stringBuffer=new StringBuffer();
	    allowAddBarcodeList.add(greenTireCode);//起始编码存放进去
		for(int i=0;i<batchNum-1;i++){
			if(i%900==0 && i!=0){
				stringBuffer.deleteCharAt(stringBuffer.length()-1);
				stringBuffer.append(") or t.barcode_s in ( ");
			}
			stringBuffer.append("'");
			stringBuffer.append(preString);
			newString=addValue(newString);
			stringBuffer.append(newString);
			stringBuffer.append("'");
			
			stringBuffer.append(",");
			allowAddBarcodeList.add(preString+newString);//所有编码添加进去
		}
		String addCodes="'"+greenTireCode+"',"+stringBuffer.toString().substring(0,stringBuffer.toString().length()-1);
		StringBuffer sbBuffer=new StringBuffer();
		sbBuffer.append( "select t.barcode_s from AT_B_MM_GREENTIREPRESTORE t where t.record_flag_s = 'A' ");
		sbBuffer.append(" and t.s_factory_s = ");	
		sbBuffer.append(LLWebUtils.factory());
		sbBuffer.append("and t.barcode_s in ( ");
		sbBuffer.append(addCodes);
		sbBuffer.append(")");
		SQLQuery query = createSQLQuery(sbBuffer.toString());
		List<Map<String, Object>> result= query.list();
		if(result==null){
			return allowAddBarcodeList;
		}
		for(Map<String, Object> item:result){
			batchAddResult.append(item.get("BARCODE_S").toString()+"数据库已经存在<br>");
			allowAddBarcodeList.remove(item.get("BARCODE_S").toString());
		}
		return allowAddBarcodeList;
	}
    
	/**
	 * 批量添加条码
	 * @param equipCode
	 * @param greenTireCode
	 * @param batchNum
	 * @return
	 * @throws Exception
	 * @author 刘程明
	 * @date 2019年4月22日
	 */
	public String BatchAdd(String equipCode,String greenTireCode,int batchNum) throws Exception {
		   List<String> newCodeList=validBatchInfo(greenTireCode, batchNum);
		
			if(newCodeList==null){
				batchAddResult.append("无新增条码");
			}
		    List<Object> GreenTireCodeBatchList = new ArrayList<>();
		    for(String newCode:newCodeList){
		    	GreenTireCodePrestore greenTireCodePrestore=new GreenTireCodePrestore();
			     greenTireCodePrestore.setBarcode_s(newCode);
			     greenTireCodePrestore.setCreated_time_t(new Date());                  //自动添加创建时间
			     greenTireCodePrestore.setRecord_flag_s("A"); 	                       //自动添加Record
			     greenTireCodePrestore.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
			     greenTireCodePrestore.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);   //自动添加机构代码-8023
			     greenTireCodePrestore.setStatus_s("01");                //自动添加胎胚条码状态
			     greenTireCodePrestore.setCreated_by_s(LLWebUtils.getUser().userCode);   //自动添加创建人
			     greenTireCodePrestore.setEquip_code_s(equipCode);
			     GreenTireCodeBatchList.add(greenTireCodePrestore);
		    }
		    save(GreenTireCodeBatchList);
		    if (batchAddResult.length()>0){
		    	String error=batchAddResult.toString();
		    	batchAddResult=new StringBuffer();
		        return error;
		    }
			return "批量导入条码成功";
	}

	/**
	 * 批量编辑胎胚列表的机台条码
	 * @param equipCode 目标机台条码
	 * @param greenTireCode
	 * @param batchNum
	 * @return
	 * @throws Exception
	 * @author 刘程明
	 * @date 2019年4月24日
	 */
	public String BatchEdit(String equipCode,String greenTireCode,String greenTireCodeEnd,int batchNum) throws Exception {
		
		StringBuffer notUpdateSearch=new StringBuffer();//查询不符合条件的轮胎条码列表
		notUpdateSearch.append("select t.barcode_s from AT_B_MM_GREENTIREPRESTORE t where t.record_flag_s='A'  and t.status_s='02' ");
		notUpdateSearch.append(" and t.barcode_s between '");
		notUpdateSearch.append(greenTireCode);
		notUpdateSearch.append("' and '");
		notUpdateSearch.append(greenTireCodeEnd);
		notUpdateSearch.append("'");
		notUpdateSearch.append("and t.s_factory_s='");
		notUpdateSearch.append(LLWebUtils.factory());
		notUpdateSearch.append("'");
		SQLQuery query = createSQLQuery(notUpdateSearch.toString());
		List<Map<String, Object>> notUpdateList= query.list();
		for(Map<String, Object> item:notUpdateList){
			batchAddResult.append(item.get("BARCODE_S").toString()+"<br>");
		}
	    Where where= new Where();
	    where.andBetween("barcode_s", greenTireCode, greenTireCodeEnd);
	    where.andEqual("s_factory_s", LLWebUtils.factory());
	    where.andEqual("record_flag_s",LLConstant.Record_Flag.AVAILIABLE);
	    where.andEqual("agenc_no_s",LLConstant.JING_MEN_CODE);
	    where.andEqual("status_s","01");
	    List<Object> uplist=findByWhere(where);
	    for(Object item:uplist){
	    	if(item instanceof GreenTireCodePrestore){
	    		GreenTireCodePrestore prestore=(GreenTireCodePrestore)item;
	    		prestore.setEquip_code_s(equipCode);
	    		prestore.setChanged_by_s(LLWebUtils.getUser().userCode);
	    		prestore.setChanged_time_t(new Date());
	    	}
	    }
	    update(uplist);
		if (batchAddResult.length()>0){
	    	String error=batchAddResult.toString()+"条码状态为已使用，不能更改机台<br>其余更新完成";
	    	batchAddResult=new StringBuffer();
	        return error;
	    }
		return "批量编辑条码成功";
	}
	
	
  /**	
	* 判重
	* 兰颖慧-2019/03
	* 
	*/
	public boolean duplicationCheck(String newAdd) throws Exception {
		Where where1 = new Where();  
		where1.andEqual("barcode_s", newAdd);
		where1.andEqual("record_flag_s", "A");     
		List<Map<String, Object>> list = findMapByWhere(where1); //
		if (list.size() != 0) //数据库内判重
		{  
			return true;
		}
		else{
			return false;
		}
	}
	  /**	
		* 结合XML获取胎胚条码最大值
		* 兰颖慧-2019/03
		* 
		*/
	public String getMaxBarcode(){
		 SQLQuery query=createSQLQuery(getSQL("getMaxBarcode"));
	     List<Map<String, Object>> list=query.list();
		 if(list==null){
			 return "9000000000";
		 }
		 return list.toString();
	}

}
