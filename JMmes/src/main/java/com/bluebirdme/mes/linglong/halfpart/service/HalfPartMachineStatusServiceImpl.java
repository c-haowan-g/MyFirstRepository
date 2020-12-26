/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartMachineStatus;
import com.bluebirdme.mes.linglong.halfpart.entity.Machinestate;


/**
 * 产线状态表
 * @author 时永良
 * @Date 2020年3月18日09:11:20
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HalfPartMachineStatusServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return null;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public String saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
    	HalfPartMachineStatus machineStatus = new HalfPartMachineStatus();
    	List<Map<String, Object>> productLineList=null;
    	List<String> errorList= new ArrayList<>();
    	int count=0;
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	productLineList=rockWellEntityDTO.getInserted();
        	for(Map<String, Object> item:productLineList){
            	count=0;
        		SQLQuery query=createSQLQuery(getSQL("getMachineStatusInfoByMachineName"));
        		query.setParameter("productLineName", item.get("p_line_name").toString());
        		query.setParameter("recordFlag",LLConstant.Record_Flag.AVAILIABLE);
        		List<Map<String, Object>> list= query.list();//无需校验list的size，前一步已校验
        		if(list.size()==0||list.isEmpty()){
        			machineStatus.setS_factory_s(LLWebUtils.factory());
        			machineStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        			machineStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        			machineStatus.setCreated_by_s(LLWebUtils.getUser().userCode);
        			machineStatus.setCreated_time_t(new Date());
        			machineStatus.setChanged_by_s(LLWebUtils.getUser().userCode);
        			machineStatus.setChanged_time_t(new Date());
        			machineStatus.setMachinebarcode_s(item.get("p_line_name").toString());//产线条码
        			machineStatus.setMachinetype_s(item.get("machinetype_s").toString());//机台类型
        			machineStatus.setMachinestatus_s("101001");  //机台状态
        			machineStatus.setIsplate_s(item.get("uda_4").toString()); //是否有口型板
        			machineStatus.setProcess_s(Process.HalfPart);//工序
        			save(machineStatus);
        		}else{
        		    for(Map<String, Object> item_1:list){
        				machineStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
        				machineStatus.setS_factory_s(LLWebUtils.factory());
        			    machineStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        			    machineStatus.setCreated_by_s(LLWebUtils.getUser().userCode);
        			    machineStatus.setCreated_time_t(new Date());
        			    machineStatus.setChanged_by_s(LLWebUtils.getUser().userCode);
        			    machineStatus.setChanged_time_t(new Date());
        			    machineStatus.setMachinebarcode_s(item.get("p_line_name").toString());//产线条码
        			    machineStatus.setMachinetype_s(item.get("machinetype_s").toString());//机台类型
        			    machineStatus.setMachinestatus_s("101001");  //机台状态
        			    machineStatus.setIsplate_s(item.get("uda_4").toString()); //是否有口型板
        			    machineStatus.setProcess_s(Process.HalfPart);//工序
        			    machineStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);//删除
        			    if(!(item_1.get("PLANNO_S")==null)){
        			    	machineStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
        			    }
        			    if(!(item_1.get("PLANQUANTITY_I")==null)){
        			    	machineStatus.setPlanquantity_i(Integer.valueOf(String.valueOf(item_1.get("PLANQUANTITY_I"))));
        			    }
                        if(!(item_1.get("MATERIALCODE_S")==null)){
                        	machineStatus.setMaterialcode_s(item_1.get("MATERIALCODE_S").toString());
        			    }
                        if(!(item_1.get("MATERIALNAME_S")==null)){
                        	machineStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());
        			    }
                        if(!(item_1.get("MATERIALSPEC_S")==null)){
                        	machineStatus.setMaterialspec_s(item_1.get("MATERIALSPEC_S").toString());
        			    }
                        if(!(item_1.get("ORDER_CODE_S")==null)){
            				machineStatus.setOrder_code_s(item_1.get("ORDER_CODE_S").toString());
        			    }
                        if(!(item_1.get("ORDER_FINISHI_I")==null)){
                        	machineStatus.setOrder_finishi_i(Integer.valueOf(String.valueOf(item_1.get("ORDER_FINISHI_I"))));
        			    }
                        if(!(item_1.get("ORDER_QUANTITY_I")==null)){
                        	machineStatus.setOrder_quantity_i(Integer.valueOf(item_1.get("ORDER_QUANTITY_I").toString()));
        			    }
                        if(!(item_1.get("CLOTHLINER_S")==null)){
                        	machineStatus.setClothliner_s(item_1.get("CLOTHLINER_S").toString());
        			    }
        			    update(machineStatus);
        			}
        			machineStatus.setS_factory_s(LLWebUtils.factory());
        			machineStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        			machineStatus.setCreated_by_s(LLWebUtils.getUser().userCode);
        			machineStatus.setCreated_time_t(new Date());
        			machineStatus.setChanged_by_s(LLWebUtils.getUser().userCode);
        			machineStatus.setChanged_time_t(new Date());
        			machineStatus.setMachinebarcode_s(item.get("p_line_name").toString());//产线条码
        			machineStatus.setMachinetype_s(item.get("machinetype_s").toString());//机台类型
        			machineStatus.setMachinestatus_s("101001");  //机台状态
        			machineStatus.setIsplate_s(item.get("uda_4").toString()); //是否有口型板
        			machineStatus.setProcess_s(Process.HalfPart);//工序
        			machineStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        			save(machineStatus);
        		}
        	}
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	productLineList=rockWellEntityDTO.getUpdated();
        	for(Map<String, Object> item:productLineList){
        		count=0;
        		SQLQuery query=createSQLQuery(getSQL("getMachineStatusInfoByMachineName"));
        		query.setParameter("productLineName", item.get("p_line_name").toString());
        		query.setParameter("recordFlag",LLConstant.Record_Flag.AVAILIABLE);
        		List<Map<String, Object>> list= query.list();//无需校验list的size，前一步已校验
        		if(list.size()==0||list.isEmpty()){
        			machineStatus.setS_factory_s(LLWebUtils.factory());
        			machineStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        			machineStatus.setCreated_by_s(LLWebUtils.getUser().userCode);
        			machineStatus.setCreated_time_t(new Date());
        			machineStatus.setChanged_by_s(LLWebUtils.getUser().userCode);
        			machineStatus.setChanged_time_t(new Date());
        			machineStatus.setMachinebarcode_s(item.get("p_line_name").toString());//产线条码
        			machineStatus.setMachinetype_s(item.get("machinetype_s").toString());//机台类型
        			machineStatus.setMachinestatus_s("101001");  //机台状态
        			machineStatus.setIsplate_s(item.get("uda_4").toString()); //是否有口型板
        			machineStatus.setProcess_s(Process.HalfPart);//工序
        			machineStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        			save(machineStatus);
        		}else{
        		    for(Map<String, Object> item_1:list){
        			   count++;
        			   if(count==1){
        			        machineStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
        					machineStatus.setS_factory_s(LLWebUtils.factory());
        					machineStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        					machineStatus.setCreated_by_s(LLWebUtils.getUser().userCode);
        					machineStatus.setCreated_time_t(new Date());
        					machineStatus.setChanged_by_s(LLWebUtils.getUser().userCode);
        					machineStatus.setChanged_time_t(new Date());
        					machineStatus.setMachinebarcode_s(item.get("p_line_name").toString());//产线条码
        					machineStatus.setMachinetype_s(item.get("machinetype_s").toString());//机台类型
        					machineStatus.setMachinestatus_s("101001");  //机台状态
        					machineStatus.setIsplate_s(item.get("uda_4").toString()); //是否有口型板
        					machineStatus.setProcess_s(Process.HalfPart);//工序
        					machineStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);//删除
            			    if(!(item_1.get("PLANNO_S")==null)){
            			    	machineStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
            			    }
            			    if(!(item_1.get("PLANQUANTITY_I")==null)){
            			    	machineStatus.setPlanquantity_i(Integer.valueOf(String.valueOf(item_1.get("PLANQUANTITY_I"))));
            			    }
                            if(!(item_1.get("MATERIALCODE_S")==null)){
                            	machineStatus.setMaterialcode_s(item_1.get("MATERIALCODE_S").toString());
            			    }
                            if(!(item_1.get("MATERIALNAME_S")==null)){
                            	machineStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());
            			    }
                            if(!(item_1.get("MATERIALSPEC_S")==null)){
                            	machineStatus.setMaterialspec_s(item_1.get("MATERIALSPEC_S").toString());
            			    }
                            if(!(item_1.get("ORDER_CODE_S")==null)){
                				machineStatus.setOrder_code_s(item_1.get("ORDER_CODE_S").toString());
            			    }
                            if(!(item_1.get("ORDER_FINISHI_I")==null)){
                            	machineStatus.setOrder_finishi_i(Integer.valueOf(String.valueOf(item_1.get("ORDER_FINISHI_I"))));
            			    }
                            if(!(item_1.get("ORDER_QUANTITY_I")==null)){
                            	machineStatus.setOrder_quantity_i(Integer.valueOf(item_1.get("ORDER_QUANTITY_I").toString()));
            			    }
                            if(!(item_1.get("CLOTHLINER_S")==null)){
                            	machineStatus.setClothliner_s(item_1.get("CLOTHLINER_S").toString());
            			    }
        					update(machineStatus);
        			   }else{
        			   	    machineStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
        					machineStatus.setS_factory_s(LLWebUtils.factory());
        					machineStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        					machineStatus.setCreated_by_s(LLWebUtils.getUser().userCode);
        					machineStatus.setCreated_time_t(new Date());
        					machineStatus.setChanged_by_s(LLWebUtils.getUser().userCode);
        					machineStatus.setChanged_time_t(new Date());
        					machineStatus.setMachinebarcode_s(item.get("p_line_name").toString());//产线条码
        					machineStatus.setMachinetype_s(item.get("machinetype_s").toString());//机台类型
        					machineStatus.setMachinestatus_s("101001");  //机台状态
        					machineStatus.setIsplate_s(item.get("uda_4").toString()); //是否有口型板
        					machineStatus.setProcess_s(Process.HalfPart);//工序
        					machineStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);//删除
            			    if(!(item_1.get("PLANNO_S")==null)){
            			    	machineStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
            			    }
            			    if(!(item_1.get("PLANQUANTITY_I")==null)){
            			    	machineStatus.setPlanquantity_i(Integer.valueOf(String.valueOf(item_1.get("PLANQUANTITY_I"))));
            			    }
                            if(!(item_1.get("MATERIALCODE_S")==null)){
                            	machineStatus.setMaterialcode_s(item_1.get("MATERIALCODE_S").toString());
            			    }
                            if(!(item_1.get("MATERIALNAME_S")==null)){
                            	machineStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());
            			    }
                            if(!(item_1.get("MATERIALSPEC_S")==null)){
                            	machineStatus.setMaterialspec_s(item_1.get("MATERIALSPEC_S").toString());
            			    }
                            if(!(item_1.get("ORDER_CODE_S")==null)){
                				machineStatus.setOrder_code_s(item_1.get("ORDER_CODE_S").toString());
            			    }
                            if(!(item_1.get("ORDER_FINISHI_I")==null)){
                            	machineStatus.setOrder_finishi_i(Integer.valueOf(String.valueOf(item_1.get("ORDER_FINISHI_I"))));
            			    }
                            if(!(item_1.get("ORDER_QUANTITY_I")==null)){
                            	machineStatus.setOrder_quantity_i(Integer.valueOf(item_1.get("ORDER_QUANTITY_I").toString()));
            			    }
                            if(!(item_1.get("CLOTHLINER_S")==null)){
                            	machineStatus.setClothliner_s(item_1.get("CLOTHLINER_S").toString());
            			    }
        					update(machineStatus);
        			   }
        			}
        		}
        	}
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	productLineList=rockWellEntityDTO.getDeleted();
        	for(Map<String, Object> item:productLineList){
        		count=0;
        		SQLQuery query=createSQLQuery(getSQL("getMachineStatusInfoByMachineName"));
        		query.setParameter("productLineName", item.get("p_line_name").toString());
        		query.setParameter("recordFlag",LLConstant.Record_Flag.AVAILIABLE);
        		List<Map<String, Object>> list= query.list();//无需校验list的size，前一步已校验
        		if(list.size()==0||list.isEmpty()){
        			continue;
        		}
        		for(Map<String, Object> item_1:list){
     				machineStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
     				machineStatus.setS_factory_s(LLWebUtils.factory());
     			    machineStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
     			    machineStatus.setCreated_by_s(LLWebUtils.getUser().userCode);
     			    machineStatus.setCreated_time_t(new Date());
     			    machineStatus.setChanged_by_s(LLWebUtils.getUser().userCode);
     			    machineStatus.setChanged_time_t(new Date());
     			    machineStatus.setMachinebarcode_s(item.get("p_line_name").toString());//产线条码
     			    machineStatus.setMachinetype_s(item.get("machinetype_s").toString());//机台类型
     			    machineStatus.setMachinestatus_s("101001");  //机台状态
     			    machineStatus.setIsplate_s(item.get("uda_4").toString()); //是否有口型板
     			    machineStatus.setProcess_s(Process.HalfPart);//工序
     			    machineStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);//删除
    			    if(!(item_1.get("PLANNO_S")==null)){
    			    	machineStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
    			    }
    			    if(!(item_1.get("PLANQUANTITY_I")==null)){
    			    	machineStatus.setPlanquantity_i(Integer.valueOf(String.valueOf(item_1.get("PLANQUANTITY_I"))));
    			    }
                    if(!(item_1.get("MATERIALCODE_S")==null)){
                    	machineStatus.setMaterialcode_s(item_1.get("MATERIALCODE_S").toString());
    			    }
                    if(!(item_1.get("MATERIALNAME_S")==null)){
                    	machineStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());
    			    }
                    if(!(item_1.get("MATERIALSPEC_S")==null)){
                    	machineStatus.setMaterialspec_s(item_1.get("MATERIALSPEC_S").toString());
    			    }
                    if(!(item_1.get("ORDER_CODE_S")==null)){
        				machineStatus.setOrder_code_s(item_1.get("ORDER_CODE_S").toString());
    			    }
                    if(!(item_1.get("ORDER_FINISHI_I")==null)){
                    	machineStatus.setOrder_finishi_i(Integer.valueOf(String.valueOf(item_1.get("ORDER_FINISHI_I"))));
    			    }
                    if(!(item_1.get("ORDER_QUANTITY_I")==null)){
                    	machineStatus.setOrder_quantity_i(Integer.valueOf(item_1.get("ORDER_QUANTITY_I").toString()));
    			    }
                    if(!(item_1.get("CLOTHLINER_S")==null)){
                    	machineStatus.setClothliner_s(item_1.get("CLOTHLINER_S").toString());
    			    }
     			    update(machineStatus);
     			}
        	}
        }
        if(errorList.size()>0){
        	return errorList.toString();
        }
        return "success";
    }
}
