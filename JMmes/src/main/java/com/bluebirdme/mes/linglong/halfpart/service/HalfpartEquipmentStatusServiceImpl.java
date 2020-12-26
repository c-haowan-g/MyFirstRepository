/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfpartEquipmentStatus;
import com.bluebirdme.mes.linglong.util.DateUtil;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 机台配置状态信息表
 * @author 兰颖慧
 * @Date 2019-05-10 09:04:17
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class HalfpartEquipmentStatusServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    @Resource SerialServiceImpl serialSrv;
    @Resource HalfPartProductLineServiceImpl productLineSrv;
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
    public String saveChanges(Map<String, Object> rockWellEntityDTO) throws Exception{
    	List<Map<String, Object>> deletedList = (List<Map<String, Object>>) rockWellEntityDTO.get("deleted");
    	List<Map<String, Object>> insertedList = (List<Map<String, Object>>) rockWellEntityDTO.get("inserted");
    	List<Map<String, Object>> updatedList = (List<Map<String, Object>>) rockWellEntityDTO.get("updated");
    	HalfpartEquipmentStatus equipStatus = new HalfpartEquipmentStatus();
    	List<Map<String, Object>> equipList=null;
    	List<String> errorList= new ArrayList<>();
    	int plasticNumber=0;
    	int existnumber=0;
    	String configSerial=null;
        if (!ListUtils.isEmpty(insertedList)) {
        	equipList=insertedList;
        	for(Map<String, Object> item:equipList){
        		plasticNumber=Integer.parseInt(item.get("plasticnumber_i").toString());
        		SQLQuery query=createSQLQuery(getSQL("getEquipStatusInfoByPlineNameAndEquipName"));
        		query.setParameter("lineName", item.get("p_line_name").toString());
        		query.setParameter("equipCode",item.get("equip_name").toString());
        		List<Map<String, Object>> list= query.list();//无需校验list的size，前一步已校验
        		if(plasticNumber==0){
        		   if(list.size()==0){
        				equipStatus.setS_factory_s(LLWebUtils.factory());
        				equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        				equipStatus.setRemark_s(Process.HalfPart);
        				equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
        				equipStatus.setCreated_time_t(new Date());//创建时间
        				equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
        				equipStatus.setChangetime_t(new Date());//修改时间
        				equipStatus.setProductionline_code_s(item.get("p_line_name").toString());//父设备-产线
        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
        				equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
        				equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
        				equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
        				equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
        				equipStatus.setEquipmentconfigcode_s(item.get("equip_name").toString().concat("_01"));//机台配置信息条码
        				equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_01"));//机台配置状态条码
        				equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        				save(equipStatus);
        		   }else{
        		        for(Map<String, Object> item_1:list){
        					equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
        					equipStatus.setS_factory_s(LLWebUtils.factory());
        					equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        					equipStatus.setRemark_s(Process.HalfPart);
        					equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
        					equipStatus.setCreated_time_t(new Date());//创建时间
        					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
        					equipStatus.setChangetime_t(new Date());//修改时间
        					equipStatus.setProductionline_code_s(item.get("p_line_name").toString());//父设备-产线
            				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
            				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
            				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
            				equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
            				equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
            				equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
            				equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
        					if(item_1.get("OUTQUANTITY_I")!=null){
        						equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
        					}
        					if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
        						equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
        					}
        					if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
        						equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
        					}
        					if(item_1.get("CURRENT_BARCODE_S")!=null){
        						equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
        					}
        					if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
        						equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
        					}
        					if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
        						equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
        					}
        					if(item_1.get("LAST_BARCODE_S")!=null){
        						equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());

        					}
        					if(item_1.get("LAST_BATCH_CODE_S")!=null){
        						equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());

        					}
        					if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
        						equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());

        					}
        					if(item_1.get("MATERIALNAME_S")!=null){
        						equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());

        					}
        					if(item_1.get("SAPM_GROUP_S")!=null){
        						equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());

        					}
        					if(item_1.get("STATUS_S")!=null){
        						equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
        					}
        					equipStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
        					equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_01"));
        					update(equipStatus);
        				}
        				equipStatus.setS_factory_s(LLWebUtils.factory());
        				equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        				equipStatus.setRemark_s(Process.HalfPart);
        				equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
        				equipStatus.setCreated_time_t(new Date());//创建时间
        				equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
        				equipStatus.setChangetime_t(new Date());//修改时间
        				equipStatus.setProductionline_code_s(item.get("p_line_name").toString());//父设备-产线
        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
        				equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
        				equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
        				equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
        				equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
        				equipStatus.setEquipmentconfigcode_s(item.get("equip_name").toString().concat("_01"));//机台配置信息条码
        				equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_01"));//机台配置状态条码
        				equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        				save(equipStatus);	
        		   }
        		}else{
        		    if(list.size()==0){
        			    for(int i=0;i<plasticNumber;i++){
        				    equipStatus.setS_factory_s(LLWebUtils.factory());
        					equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        					equipStatus.setRemark_s(Process.HalfPart);
        					equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
        					equipStatus.setCreated_time_t(new Date());//创建时间
        					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
        					equipStatus.setChangetime_t(new Date());//修改时间
        					equipStatus.setProductionline_code_s(item.get("p_line_name").toString());//父设备-产线
            				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
            				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
            				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
            				equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
            				equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
            				equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
            				equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
        					equipStatus.setEquipmentconfigcode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(i+1)));//机台配置信息条码
        					equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(i+1)));//机台配置状态条码
        					equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        					save(equipStatus);
        				}
        		   }else{
        		        for(Map<String, Object> item_1:list){
        					equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
        					equipStatus.setS_factory_s(LLWebUtils.factory());
        					equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        					equipStatus.setRemark_s(Process.HalfPart);
        					equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
        					equipStatus.setCreated_time_t(new Date());//创建时间
        					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
        					equipStatus.setChangetime_t(new Date());//修改时间
        					equipStatus.setProductionline_code_s(item.get("p_line_name").toString());//父设备-产线
            				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
            				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
            				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
            				equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
            				equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
            				equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
            				equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
        					if(item_1.get("OUTQUANTITY_I")!=null){
        						equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
        					}
        					if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
        						equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
        					}
        					if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
        						equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
        					}
        					if(item_1.get("CURRENT_BARCODE_S")!=null){
        						equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
        					}
        					if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
        						equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
        					}
        					if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
        						equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
        					}
        					if(item_1.get("LAST_BARCODE_S")!=null){
        						equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());

        					}
        					if(item_1.get("LAST_BATCH_CODE_S")!=null){
        						equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());

        					}
        					if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
        						equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());

        					}
        					if(item_1.get("MATERIALNAME_S")!=null){
        						equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());

        					}
        					if(item_1.get("SAPM_GROUP_S")!=null){
        						equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());

        					}
        					if(item_1.get("STATUS_S")!=null){
        						equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
        					}
        					equipStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
        					equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_01"));
        					update(equipStatus);
        				}
        			    for(int i=0;i<plasticNumber;i++){
        				    equipStatus.setS_factory_s(LLWebUtils.factory());
        					equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
        					equipStatus.setRemark_s(Process.HalfPart);
        					equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
        					equipStatus.setCreated_time_t(new Date());//创建时间
        					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
        					equipStatus.setChangetime_t(new Date());//修改时间
        					equipStatus.setProductionline_code_s(item.get("p_line_name").toString());//父设备-产线
            				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
            				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
            				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
            				equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
            				equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
            				equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
            				equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
        					equipStatus.setEquipmentconfigcode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(i+1)));//机台配置信息条码
        					equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(i+1)));//机台配置状态条码
        					equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        					save(equipStatus);
        				}
        		   }
        		}
        	}
        }
        if (!ListUtils.isEmpty(updatedList)) {
        	equipList=updatedList;
        	for(Map<String, Object> item:equipList){
        		int count=0;
        		Long plasticNum=Long.valueOf(item.get("plasticnumber_i").toString());
            	SQLQuery query=createSQLQuery(getSQL("getEquipStatusInfoByPlineNameAndEquipName"));
          		query.setParameter("lineName", item.get("equip_name").toString().substring(0, 6));
          		query.setParameter("equipCode", item.get("equip_name").toString());
          		List<Map<String, Object>> list= query.list();//无需校验list的size，前一步已校验
          		if(plasticNum==0){
          			count=0;
          			if(list.size()==0||list==null){
    		       		equipStatus.setS_factory_s(LLWebUtils.factory());
    		       		equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
    		       		equipStatus.setRemark_s(Process.HalfPart);
    		       		equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
    		       		equipStatus.setCreated_time_t(new Date());//创建时间
    		       	    equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
    		       	    equipStatus.setChangetime_t(new Date());//修改时间
    		       		equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
        				if(item.get("ip_address_s")!=null){
        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
        				}else{
        					equipStatus.setIp_address_s("");//设备IP
        				}
        				if(item.get("specialselect_s")!=null){
        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
        				}else{
        					equipStatus.setEquipspecialselect_s(""); //特殊选择
        				}
        				if(item.get("rfidaddress_s")!=null){
        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
        				}else{
        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
        				}
        				if(item.get("outputgroup_s")!=null){
        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
        				}else{
        					equipStatus.setOutputgroup_s("");//产出分组
        				}
    		       		equipStatus.setEquipmentconfigcode_s(item.get("equip_name").toString().concat("_01"));//机台配置信息条码
    		       		equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_01"));//机台配置状态条码
    		       		equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
        			    save(equipStatus);
          			}else{
	          			for(Map<String, Object> item_1:list){
	          				if(count==0){
			    	    		equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
			        			equipStatus.setS_factory_s(LLWebUtils.factory());
			    	    		equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
			    	    		equipStatus.setRemark_s(Process.HalfPart);
			            		equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
			            		equipStatus.setCreated_time_t(new Date());//创建时间
//			    	    	    equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
			    	    	    equipStatus.setChangetime_t(new Date());//修改时间
			    	    	    equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
		        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
		        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
		        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
		        				if(item.get("ip_address_s")!=null){
		        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
		        				}else{
		        					equipStatus.setIp_address_s("");//设备IP
		        				}
		        				if(item.get("specialselect_s")!=null){
		        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
		        				}else{
		        					equipStatus.setEquipspecialselect_s(""); //特殊选择
		        				}
		        				if(item.get("rfidaddress_s")!=null){
		        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
		        				}else{
		        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
		        				}
		        				if(item.get("outputgroup_s")!=null){
		        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
		        				}else{
		        					equipStatus.setOutputgroup_s("");//产出分组
		        				}
			    	    		if(item_1.get("OUTQUANTITY_I")!=null){
			    	    			equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
			    	    		}
			    	    		if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
			    	    			equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
			    	    		}
			    	    		if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
			    	    			equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
			    	    		}
			    	    		if(item_1.get("CURRENT_BARCODE_S")!=null){
			    	    			equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
			    	    		}
			    	    		if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
			    	    			equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
			    	    		}
			    	    		if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
			    	    			equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
			    	    		}
			    	    		if(item_1.get("LAST_BARCODE_S")!=null){
				    	    		equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());
	
			    	    		}
			    	    		if(item_1.get("LAST_BATCH_CODE_S")!=null){
				    	    		equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());
	
			    	    		}
			    	    		if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
				    	    		equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());
	
			    	    		}
			    	    		if(item_1.get("MATERIALNAME_S")!=null){
				    	    		equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());
	
			    	    		}
			    	    		if(item_1.get("SAPM_GROUP_S")!=null){
				    	    		equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());
	
			    	    		}
			    	    		if(item_1.get("STATUS_S")!=null){
				    	    		equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
			    	    		}
			    	    		
			    	    		if(item_1.get("PLANNO_S")!=null){
          							equipStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
          						}
			    	    		
			    	    		if(item_1.get("PLANQUANTITY_I")!=null){
          							equipStatus.setPlanquantity_i(Integer.parseInt(item_1.get("PLANQUANTITY_I").toString()));
          						}
          						if(item_1.get("CREATED_BY_S")!=null){
          							equipStatus.setChangeby_s(item_1.get("CREATED_BY_S").toString());
          						}
          						if(item_1.get("CONFIGCLASS_S")!=null){
          							equipStatus.setConfigclass_s(item_1.get("CONFIGCLASS_S").toString());
          						}
          						if(item_1.get("CHANGED_BY_S")!=null){
          							equipStatus.setChanged_by_s(item_1.get("CHANGED_BY_S").toString());
          						}
          						if(item_1.get("CHANGED_TIME_T")!=null){
          							equipStatus.setChanged_time_t(DateUtil.strToUtilDate(item_1.get("CHANGED_TIME_T").toString(), "yyyy-MM-dd HH:mm:ss"));
          						}
          						if(item_1.get("SPARE1_S")!=null){
          							equipStatus.setSpare1_s(item_1.get("SPARE1_S").toString());
          						}
			    	    		
			    	    		equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
			    	    		equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(count+1)));
			    	    		update(equipStatus);
			    	    		count++;
	          				}else{
			    	    		equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
			        			equipStatus.setS_factory_s(LLWebUtils.factory());
			    	    		equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
			    	    		equipStatus.setRemark_s(Process.HalfPart);
			            		equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
			            		equipStatus.setCreated_time_t(new Date());//创建时间
//			    	    	    equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
			    	    	    equipStatus.setChangetime_t(new Date());//修改时间
			    	    	    equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
		        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
		        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
		        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
		        				if(item.get("ip_address_s")!=null){
		        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
		        				}else{
		        					equipStatus.setIp_address_s("");//设备IP
		        				}
		        				if(item.get("specialselect_s")!=null){
		        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
		        				}else{
		        					equipStatus.setEquipspecialselect_s(""); //特殊选择
		        				}
		        				if(item.get("rfidaddress_s")!=null){
		        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
		        				}else{
		        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
		        				}
		        				if(item.get("outputgroup_s")!=null){
		        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
		        				}else{
		        					equipStatus.setOutputgroup_s("");//产出分组
		        				}
			    	    		if(item_1.get("OUTQUANTITY_I")!=null){
			    	    			equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
			    	    		}
			    	    		if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
			    	    			equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
			    	    		}
			    	    		if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
			    	    			equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
			    	    		}
			    	    		if(item_1.get("CURRENT_BARCODE_S")!=null){
			    	    			equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
			    	    		}
			    	    		if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
			    	    			equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
			    	    		}
			    	    		if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
			    	    			equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
			    	    		}
			    	    		if(item_1.get("LAST_BARCODE_S")!=null){
				    	    		equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());
	
			    	    		}
			    	    		if(item_1.get("LAST_BATCH_CODE_S")!=null){
				    	    		equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());
	
			    	    		}
			    	    		if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
				    	    		equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());
	
			    	    		}
			    	    		if(item_1.get("MATERIALNAME_S")!=null){
				    	    		equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());
	
			    	    		}
			    	    		if(item_1.get("SAPM_GROUP_S")!=null){
				    	    		equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());
	
			    	    		}
			    	    		if(item_1.get("STATUS_S")!=null){
				    	    		equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
			    	    		}
			    	    		
			    	    		if(item_1.get("PLANNO_S")!=null){
          							equipStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
          						}
			    	    		
			    	    		if(item_1.get("PLANQUANTITY_I")!=null){
          							equipStatus.setPlanquantity_i(Integer.parseInt(item_1.get("PLANQUANTITY_I").toString()));
          						}
          						if(item_1.get("CREATED_BY_S")!=null){
          							equipStatus.setChangeby_s(item_1.get("CREATED_BY_S").toString());
          						}
          						if(item_1.get("CONFIGCLASS_S")!=null){
          							equipStatus.setConfigclass_s(item_1.get("CONFIGCLASS_S").toString());
          						}
          						if(item_1.get("CHANGED_BY_S")!=null){
          							equipStatus.setChanged_by_s(item_1.get("CHANGED_BY_S").toString());
          						}
          						if(item_1.get("CHANGED_TIME_T")!=null){
          							equipStatus.setChanged_time_t(DateUtil.strToUtilDate(item_1.get("CHANGED_TIME_T").toString(), "yyyy-MM-dd HH:mm:ss"));
          						}
          						if(item_1.get("SPARE1_S")!=null){
          							equipStatus.setSpare1_s(item_1.get("SPARE1_S").toString());
          						}
			    	    		
			    	    		equipStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
			    	    		equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(count+1)));
			    	    		update(equipStatus);
	          				}
	          			}
	          			
	          		}
          		}
          		else{
          			if(list.size()==0||list==null){
          				for(int i=0;i<plasticNum;i++){
          					equipStatus.setS_factory_s(LLWebUtils.factory());
          					equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
          					equipStatus.setRemark_s(Process.HalfPart);
          					equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
          					equipStatus.setCreated_time_t(new Date());//创建时间
          					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
          					equipStatus.setChangetime_t(new Date());//修改时间
          					 equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
		        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
		        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
		        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
		        				if(item.get("ip_address_s")!=null){
		        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
		        				}else{
		        					equipStatus.setIp_address_s("");//设备IP
		        				}
		        				if(item.get("specialselect_s")!=null){
		        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
		        				}else{
		        					equipStatus.setEquipspecialselect_s(""); //特殊选择
		        				}
		        				if(item.get("rfidaddress_s")!=null){
		        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
		        				}else{
		        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
		        				}
		        				if(item.get("outputgroup_s")!=null){
		        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
		        				}else{
		        					equipStatus.setOutputgroup_s("");//产出分组
		        				}
          					equipStatus.setEquipmentconfigcode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(i+1)));//机台配置信息条码
          					equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(i+1)));//机台配置状态条码
          					equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
          					save(equipStatus);
          				}
          			}
          			else if(plasticNum==Long.valueOf(list.size())){
          			        count=0;
          					for(Map<String, Object> item_1:list){
          					    count++;
          						equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
          						equipStatus.setS_factory_s(LLWebUtils.factory());
          						equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
          						equipStatus.setRemark_s(Process.HalfPart);
          						equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
          						equipStatus.setCreated_time_t(new Date());//创建时间
//          					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
          						equipStatus.setChangetime_t(new Date());//修改时间
          						equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
		        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
		        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
		        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
		        				if(item.get("ip_address_s")!=null){
		        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
		        				}else{
		        					equipStatus.setIp_address_s("");//设备IP
		        				}
		        				if(item.get("specialselect_s")!=null){
		        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
		        				}else{
		        					equipStatus.setEquipspecialselect_s(""); //特殊选择
		        				}
		        				if(item.get("rfidaddress_s")!=null){
		        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
		        				}else{
		        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
		        				}
		        				if(item.get("outputgroup_s")!=null){
		        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
		        				}else{
		        					equipStatus.setOutputgroup_s("");//产出分组
		        				}
          						if(item_1.get("OUTQUANTITY_I")!=null){
          							equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
          						}
          						if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
          							equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
          						}
          						if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
          							equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
          						}
          						if(item_1.get("CURRENT_BARCODE_S")!=null){
          							equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
          						}
          						if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
          							equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
          						}
          						if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
          							equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
          						}
          						if(item_1.get("LAST_BARCODE_S")!=null){
          							equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());

          						}
          						if(item_1.get("LAST_BATCH_CODE_S")!=null){
          							equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());

          						}
          						if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
          							equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());

          						}
          						if(item_1.get("MATERIALNAME_S")!=null){
          							equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());

          						}
          						if(item_1.get("SAPM_GROUP_S")!=null){
          							equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());

          						}
          						if(item_1.get("STATUS_S")!=null){
          							equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
          						}
          						
          						if(item_1.get("PLANNO_S")!=null){
          							equipStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
          						}
          						
          						if(item_1.get("PLANQUANTITY_I")!=null){
          							equipStatus.setPlanquantity_i(Integer.parseInt(item_1.get("PLANQUANTITY_I").toString()));
          						}
          						if(item_1.get("CREATED_BY_S")!=null){
          							equipStatus.setChangeby_s(item_1.get("CREATED_BY_S").toString());
          						}
          						if(item_1.get("CONFIGCLASS_S")!=null){
          							equipStatus.setConfigclass_s(item_1.get("CONFIGCLASS_S").toString());
          						}
          						if(item_1.get("CHANGED_BY_S")!=null){
          							equipStatus.setChanged_by_s(item_1.get("CHANGED_BY_S").toString());
          						}
          						if(item_1.get("CHANGED_TIME_T")!=null){
          							equipStatus.setChanged_time_t(DateUtil.strToUtilDate(item_1.get("CHANGED_TIME_T").toString(), "yyyy-MM-dd HH:mm:ss"));
          						}
          						if(item_1.get("SPARE1_S")!=null){
          							equipStatus.setSpare1_s(item_1.get("SPARE1_S").toString());
          						}
          						
          						equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
          						equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().toString().concat("_0").concat(String.valueOf(count)));
          						
//          					equipStatus.setOutputgroup_s(item_1.get("OUTPUTGROUP_S").toString());
//          					equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
//          					equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
//          					equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());
//          					equipStatus.setOutquantity_i(Long.parseLong(item_1.get("OUTQUANTITY_I").toString()));
          						
          						update(equipStatus);
          					}
          			}
          			else if(plasticNum<list.size()){
          			    count=0;
          			    for(Map<String, Object> item_1:list){
          				    count++;
          					if(count<=plasticNum){
          						equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
          						equipStatus.setS_factory_s(LLWebUtils.factory());
          						equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
          						equipStatus.setRemark_s(Process.HalfPart);
          						equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
          						equipStatus.setCreated_time_t(new Date());//创建时间
//          					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
          						equipStatus.setChangetime_t(new Date());//修改时间
          						equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
		        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
		        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
		        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
		        				if(item.get("ip_address_s")!=null){
		        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
		        				}else{
		        					equipStatus.setIp_address_s("");//设备IP
		        				}
		        				if(item.get("specialselect_s")!=null){
		        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
		        				}else{
		        					equipStatus.setEquipspecialselect_s(""); //特殊选择
		        				}
		        				if(item.get("rfidaddress_s")!=null){
		        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
		        				}else{
		        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
		        				}
		        				if(item.get("outputgroup_s")!=null){
		        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
		        				}else{
		        					equipStatus.setOutputgroup_s("");//产出分组
		        				}
          						if(item_1.get("OUTQUANTITY_I")!=null){
          							equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
          						}
          						if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
          							equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
          						}
          						if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
          							equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
          						}
          						if(item_1.get("CURRENT_BARCODE_S")!=null){
          							equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
          						}
          						if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
          							equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
          						}
          						if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
          							equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
          						}
          						if(item_1.get("LAST_BARCODE_S")!=null){
          							equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());

          						}
          						if(item_1.get("LAST_BATCH_CODE_S")!=null){
          							equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());

          						}
          						if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
          							equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());

          						}
          						if(item_1.get("MATERIALNAME_S")!=null){
          							equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());

          						}
          						if(item_1.get("SAPM_GROUP_S")!=null){
          							equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());

          						}
          						if(item_1.get("STATUS_S")!=null){
          							equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
          						}
          						
          						if(item_1.get("PLANNO_S")!=null){
          							equipStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
          						}
          						
          						if(item_1.get("PLANQUANTITY_I")!=null){
          							equipStatus.setPlanquantity_i(Integer.parseInt(item_1.get("PLANQUANTITY_I").toString()));
          						}
          						if(item_1.get("CREATED_BY_S")!=null){
          							equipStatus.setChangeby_s(item_1.get("CREATED_BY_S").toString());
          						}
          						if(item_1.get("CONFIGCLASS_S")!=null){
          							equipStatus.setConfigclass_s(item_1.get("CONFIGCLASS_S").toString());
          						}
          						if(item_1.get("CHANGED_BY_S")!=null){
          							equipStatus.setChanged_by_s(item_1.get("CHANGED_BY_S").toString());
          						}
          						if(item_1.get("CHANGED_TIME_T")!=null){
          							equipStatus.setChanged_time_t(DateUtil.strToUtilDate(item_1.get("CHANGED_TIME_T").toString(), "yyyy-MM-dd HH:mm:ss"));
          						}
          						if(item_1.get("SPARE1_S")!=null){
          							equipStatus.setSpare1_s(item_1.get("SPARE1_S").toString());
          						}
          						
          						equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
          						equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(count)));
          						update(equipStatus);
          					}else if(count>plasticNum){
          						equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
          						equipStatus.setS_factory_s(LLWebUtils.factory());
          						equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
          						equipStatus.setRemark_s(Process.HalfPart);
          						equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
          						equipStatus.setCreated_time_t(new Date());//创建时间
//          					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
          						equipStatus.setChangetime_t(new Date());//修改时间
          						equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
		        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
		        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
		        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
		        				if(item.get("ip_address_s")!=null){
		        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
		        				}else{
		        					equipStatus.setIp_address_s("");//设备IP
		        				}
		        				if(item.get("specialselect_s")!=null){
		        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
		        				}else{
		        					equipStatus.setEquipspecialselect_s(""); //特殊选择
		        				}
		        				if(item.get("rfidaddress_s")!=null){
		        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
		        				}else{
		        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
		        				}
		        				if(item.get("outputgroup_s")!=null){
		        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
		        				}else{
		        					equipStatus.setOutputgroup_s("");//产出分组
		        				}
          						if(item_1.get("OUTQUANTITY_I")!=null){
          							equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
          						}
          						if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
          							equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
          						}
          						if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
          							equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
          						}
          						if(item_1.get("CURRENT_BARCODE_S")!=null){
          							equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
          						}
          						if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
          							equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
          						}
          						if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
          							equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
          						}
          						if(item_1.get("LAST_BARCODE_S")!=null){
          							equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());

          						}
          						if(item_1.get("LAST_BATCH_CODE_S")!=null){
          							equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());

          						}
          						if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
          							equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());

          						}
          						if(item_1.get("MATERIALNAME_S")!=null){
          							equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());

          						}
          						if(item_1.get("SAPM_GROUP_S")!=null){
          							equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());

          						}
          						if(item_1.get("STATUS_S")!=null){
          							equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
          						}
          						
          						if(item_1.get("PLANNO_S")!=null){
          							equipStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
          						}
          						
          						if(item_1.get("PLANQUANTITY_I")!=null){
          							equipStatus.setPlanquantity_i(Integer.parseInt(item_1.get("PLANQUANTITY_I").toString()));
          						}
          						if(item_1.get("CREATED_BY_S")!=null){
          							equipStatus.setChangeby_s(item_1.get("CREATED_BY_S").toString());
          						}
          						if(item_1.get("CONFIGCLASS_S")!=null){
          							equipStatus.setConfigclass_s(item_1.get("CONFIGCLASS_S").toString());
          						}
          						if(item_1.get("CHANGED_BY_S")!=null){
          							equipStatus.setChanged_by_s(item_1.get("CHANGED_BY_S").toString());
          						}
          						if(item_1.get("CHANGED_TIME_T")!=null){
          							equipStatus.setChanged_time_t(DateUtil.strToUtilDate(item_1.get("CHANGED_TIME_T").toString(), "yyyy-MM-dd HH:mm:ss"));
          						}
          						if(item_1.get("SPARE1_S")!=null){
          							equipStatus.setSpare1_s(item_1.get("SPARE1_S").toString());
          						}
          						
          						equipStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
          						equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().toString().concat("_01"));
          						update(equipStatus);
          					}
          				}	
          			}
          			else if(plasticNum>list.size()){
          			    count=0;
          				long addNum = plasticNum-list.size();
          			    for(Map<String, Object> item_1:list){
          				    count++;
          					equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
          					equipStatus.setS_factory_s(LLWebUtils.factory());
          					equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
          					equipStatus.setRemark_s(Process.HalfPart);
          					equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
          					equipStatus.setCreated_time_t(new Date());//创建时间
//          				equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
          					equipStatus.setChangetime_t(new Date());//修改时间
          					equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
	        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
	        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
	        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
	        				if(item.get("ip_address_s")!=null){
	        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
	        				}else{
	        					equipStatus.setIp_address_s("");//设备IP
	        				}
	        				if(item.get("specialselect_s")!=null){
	        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
	        				}else{
	        					equipStatus.setEquipspecialselect_s(""); //特殊选择
	        				}
	        				if(item.get("rfidaddress_s")!=null){
	        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
	        				}else{
	        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
	        				}
	        				if(item.get("outputgroup_s")!=null){
	        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
	        				}else{
	        					equipStatus.setOutputgroup_s("");//产出分组
	        				}
          					if(item_1.get("OUTQUANTITY_I")!=null){
          						equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
          					}
          					if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
          						equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
          					}
          					if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
          						equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
          					}
          					if(item_1.get("CURRENT_BARCODE_S")!=null){
          						equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
          					}
          					if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
          						equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
          					}
          					if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
          						equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
          					}
          					if(item_1.get("LAST_BARCODE_S")!=null){
          						equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());

          					}
          					if(item_1.get("LAST_BATCH_CODE_S")!=null){
          						equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());

          					}
          					if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
          						equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());

          					}
          					if(item_1.get("MATERIALNAME_S")!=null){
          						equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());

          					}
          					if(item_1.get("SAPM_GROUP_S")!=null){
          						equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());

          					}
          					if(item_1.get("STATUS_S")!=null){
          						equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
          					}
          					
          					if(item_1.get("PLANNO_S")!=null){
      							equipStatus.setPlanno_s(item_1.get("PLANNO_S").toString());
      						}
          					
          					if(item_1.get("PLANQUANTITY_I")!=null){
      							equipStatus.setPlanquantity_i(Integer.parseInt(item_1.get("PLANQUANTITY_I").toString()));
      						}
      						if(item_1.get("CREATED_BY_S")!=null){
      							equipStatus.setChangeby_s(item_1.get("CREATED_BY_S").toString());
      						}
      						if(item_1.get("CONFIGCLASS_S")!=null){
      							equipStatus.setConfigclass_s(item_1.get("CONFIGCLASS_S").toString());
      						}
      						if(item_1.get("CHANGED_BY_S")!=null){
      							equipStatus.setChanged_by_s(item_1.get("CHANGED_BY_S").toString());
      						}
      						if(item_1.get("CHANGED_TIME_T")!=null){
      							equipStatus.setChanged_time_t(DateUtil.strToUtilDate(item_1.get("CHANGED_TIME_T").toString(), "yyyy-MM-dd HH:mm:ss"));
      						}
      						if(item_1.get("SPARE1_S")!=null){
      							equipStatus.setSpare1_s(item_1.get("SPARE1_S").toString());
      						}
          					
          					equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
          					equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(count)));
          					update(equipStatus);
          				}
          				for(int i=0;i<addNum;i++){
          					count++;
          					equipStatus.setS_factory_s(LLWebUtils.factory());
          					equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
          					equipStatus.setRemark_s(Process.HalfPart);
          					equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
          					equipStatus.setCreated_time_t(new Date());//创建时间
          					equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
          					equipStatus.setChangetime_t(new Date());//修改时间
          					equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
	        				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
	        				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
	        				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
	        				if(item.get("ip_address_s")!=null){
	        					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
	        				}else{
	        					equipStatus.setIp_address_s("");//设备IP
	        				}
	        				if(item.get("specialselect_s")!=null){
	        					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
	        				}else{
	        					equipStatus.setEquipspecialselect_s(""); //特殊选择
	        				}
	        				if(item.get("rfidaddress_s")!=null){
	        					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
	        				}else{
	        					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
	        				}
	        				if(item.get("outputgroup_s")!=null){
	        					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
	        				}else{
	        					equipStatus.setOutputgroup_s("");//产出分组
	        				}
          					equipStatus.setEquipmentconfigcode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(count)));//机台配置信息条码
          					equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(count)));//机台配置状态条码
          					equipStatus.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
          					save(equipStatus);
          				}
          			}
          		}
        	}
        }

        if (!ListUtils.isEmpty(deletedList)) {
        	equipList=deletedList;
        	int count=0;
        	for(Map<String, Object> item:equipList){
        		plasticNumber=Integer.parseInt(item.get("plasticnumber_i").toString());
        		SQLQuery query=createSQLQuery(getSQL("getEquipStatusInfoByPlineNameAndEquipName"));
        		query.setParameter("lineName", item.get("equip_name").toString().substring(0, 6));
        		query.setParameter("equipCode",item.get("equip_name").toString());
        		List<Map<String, Object>> list= query.list();//无需校验list的size，前一步已校验
	    		if(list.size()==0||list.isEmpty()){
	    			continue;
	    		}
    	        for(Map<String, Object> item_1:list){
    	        	count++;
    				equipStatus.setAtr_key(Long.valueOf(item_1.get("ATR_KEY").toString()));//设置主键
    				equipStatus.setS_factory_s(LLWebUtils.factory());
    				equipStatus.setAgenc_no_s(LLConstant.JING_MEN_CODE);
    				equipStatus.setRemark_s(Process.HalfPart);
    				equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
    				equipStatus.setCreated_time_t(new Date());//创建时间
    				equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
    				equipStatus.setChangetime_t(new Date());//修改时间
    				equipStatus.setProductionline_code_s(item.get("equip_name").toString().substring(0, 6));//父设备-产线
    				equipStatus.setEquipmentcode_s(item.get("equip_name").toString());//设备代码
    				equipStatus.setEquipmentname_s(item.get("description").toString()); //设备名称
    				equipStatus.setEquip_type_s(item.get("equip_type_s").toString());//设备类型
    				if(item.get("ip_address_s")!=null){
    					equipStatus.setIp_address_s(item.get("ip_address_s").toString());//设备IP
    				}else{
    					equipStatus.setIp_address_s("");//设备IP
    				}
    				if(item.get("specialselect_s")!=null){
    					equipStatus.setEquipspecialselect_s(item.get("specialselect_s").toString()); //特殊选择
    				}else{
    					equipStatus.setEquipspecialselect_s(""); //特殊选择
    				}
    				if(item.get("rfidaddress_s")!=null){
    					equipStatus.setRfid_antenna_code_s(item.get("rfidaddress_s").toString()); //RFID逻辑地址
    				}else{
    					equipStatus.setRfid_antenna_code_s(""); //RFID逻辑地址
    				}
    				if(item.get("outputgroup_s")!=null){
    					equipStatus.setOutputgroup_s(item.get("outputgroup_s").toString());//产出分组
    				}else{
    					equipStatus.setOutputgroup_s("");//产出分组
    				}
    				if(item_1.get("OUTQUANTITY_I")!=null){
    					equipStatus.setOutquantity_i(Long.valueOf(item_1.get("OUTQUANTITY_I").toString()));
    				}
    				if(item_1.get("EQUIPMENTCONFIGCODE_S")!=null){
    					equipStatus.setEquipmentconfigcode_s(item_1.get("EQUIPMENTCONFIGCODE_S").toString());
    				}
    				if(item_1.get("EQUIPMENTSTATUSCODE_S")!=null){
    					equipStatus.setEquipmentstatuscode_s(item_1.get("EQUIPMENTSTATUSCODE_S").toString());
    				}
    				if(item_1.get("CURRENT_BARCODE_S")!=null){
    					equipStatus.setCurrent_barcode_s(item_1.get("CURRENT_BARCODE_S").toString());
    				}
    				if(item_1.get("CURRENT_BATCH_CODE_S")!=null){
    					equipStatus.setCurrent_batch_code_s(item_1.get("CURRENT_BATCH_CODE_S").toString());
    				}
    				if(item_1.get("CURRENT_MATERIAL_CODE_S")!=null){
    					equipStatus.setCurrent_material_code_s(item_1.get("CURRENT_MATERIAL_CODE_S").toString());
    				}
    				if(item_1.get("LAST_BARCODE_S")!=null){
    					equipStatus.setLast_barcode_s(item_1.get("LAST_BARCODE_S").toString());

    				}
    				if(item_1.get("LAST_BATCH_CODE_S")!=null){
    					equipStatus.setLast_batch_code_s(item_1.get("LAST_BATCH_CODE_S").toString());

    				}
    				if(item_1.get("LAST_MATERIAL_CODE_S")!=null){
    					equipStatus.setLast_material_code_s(item_1.get("LAST_MATERIAL_CODE_S").toString());

    				}
    				if(item_1.get("MATERIALNAME_S")!=null){
    					equipStatus.setMaterialname_s(item_1.get("MATERIALNAME_S").toString());

    				}
    				if(item_1.get("SAPM_GROUP_S")!=null){
    					equipStatus.setSapm_group_s(item_1.get("SAPM_GROUP_S").toString());

    				}
    				if(item_1.get("STATUS_S")!=null){
    					equipStatus.setStatus_s(item_1.get("STATUS_S").toString());
    				}
    				equipStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
    				equipStatus.setEquipmentstatuscode_s(item.get("equip_name").toString().concat("_0").concat(String.valueOf(count)));
    				update(equipStatus);
    			}
         }
        }
        if(errorList.size()>0){
        	return errorList.toString();
        }
		return "success";
     }
    /**
     * 直接删掉带有子设备的产线时调用
     * @param productLineName
     * @return
     * @throws Exception
     */
   /* public String deleteEquip(String productLineName) throws Exception{  //??
    	HalfpartEquipmentStatus equipStatus = new HalfpartEquipmentStatus();
    	HalfpartEquipmentLog equipLog = new HalfpartEquipmentLog();
    	List<String> errorList= new ArrayList<>();
    	Integer plasticNumber=0;
    	SQLQuery query=createSQLQuery(getSQL("getEquipNameByPlineName"));
  		query.setParameter("p_line_name", productLineName);
  		List<Map<String, Object>> list= query.list();//无需校验list的size，前一步已校验
    	for(Map<String, Object> item:list){
    		
    		SQLQuery getAtrKeyByEquipName=getSession().createSQLQuery(getSQL("getAtrKeyByEquipName"));
    		getAtrKeyByEquipName.setParameter("equipName",item.get("EQUIP_NAME").toString());
    		getAtrKeyByEquipName.setParameter("recordFlag","A");
    		if(getAtrKeyByEquipName.list().size()==0||getAtrKeyByEquipName.list().isEmpty()){
    			continue;
    		}
    		plasticNumber=Integer.parseInt(item.get("PLASTICNUMBER_I").toString());
    		if(plasticNumber==0){
	    		equipStatus.setAtr_key(Long.parseLong((getAtrKeyByEquipName.list().get(0).toString())));//设置主键
    			equipStatus.setS_factory_s(LLWebUtils.factory());
	    		equipStatus.setAgenc_no_s(LLConstant.LIU_ZHOU_CODE);
	    		equipStatus.setEquipmentcode_s(item.get("EQUIP_NAME").toString());//设备代码
	    		equipStatus.setEquipmentname_s(item.get("DESCRIPTION").toString()); //设备名称
	    		equipStatus.setEquip_type_s(item.get("EQUIP_TYPE_S").toString());//设备类型
	    		if(item.get("IP_ADDRESS_S")!=null){
	    			equipStatus.setIp_address_s(item.get("IP_ADDRESS_S").toString());//设备IP
	    		}
	    		equipStatus.setEquipmentconfigcode_s("HALFPART");
        		equipStatus.setEquipmentstatuscode_s(item.get("EQUIP_NAME").toString().concat("_01"));
	    		if(item.get("OUTPUTGROUP_S")!=null){
	    			equipStatus.setOutputgroup_s(item.get("OUTPUTGROUP_S").toString());//产出分组
	    		}
	    		equipStatus.setProductionline_code_s(productLineName);//父设备-产线
        		equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
        		equipStatus.setCreated_time_t(new Date());//创建时间
	    	    equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
	    	    equipStatus.setChangetime_t(new Date());//修改时间
	    		equipStatus.setRemark_s(Process.HalfPart);
	    	    equipStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
	    		update(equipStatus);
    		}else{
	    		for(int j=0;j<plasticNumber;j++){
		    		equipStatus.setAtr_key(Long.parseLong((getAtrKeyByEquipName.list().get(j).toString())));//设置主键
	    			equipStatus.setS_factory_s(LLWebUtils.factory());
		    		equipStatus.setAgenc_no_s(LLConstant.LIU_ZHOU_CODE);
		    		equipStatus.setEquipmentcode_s(item.get("EQUIP_NAME").toString());//设备代码
		    		equipStatus.setEquipmentname_s(item.get("DESCRIPTION").toString()); //设备名称
		    		equipStatus.setEquip_type_s(item.get("EQUIP_TYPE_S").toString());//设备类型
		    		if(item.get("IP_ADDRESS_S")!=null){
		    			equipStatus.setIp_address_s(item.get("IP_ADDRESS_S").toString());//设备IP
		    		}
		    		equipStatus.setEquipmentconfigcode_s("HALFPART");
		    		String plasticNum=String.valueOf(plasticNumber-j);
	        		equipStatus.setEquipmentstatuscode_s(item.get("EQUIP_NAME").toString().concat("_0").concat(String.valueOf(plasticNum)));
		    		if(item.get("OUTPUTGROUP_S")!=null){
		    			equipStatus.setOutputgroup_s(item.get("OUTPUTGROUP_S").toString());//产出分组
		    		}
		    		equipStatus.setProductionline_code_s(productLineName);//父设备-产线
	        		equipStatus.setCreated_by_s(LLWebUtils.getUser().userCode);//创建人
	        		equipStatus.setCreated_time_t(new Date());//创建时间
		    	    equipStatus.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
		    	    equipStatus.setChangetime_t(new Date());//修改时间
		    		equipStatus.setRemark_s(Process.HalfPart);
		    	    equipStatus.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
		    		update(equipStatus);
		    		}
    		}
    		//更新设备记录表内的数据
    		equipLog.setName_s(item.get("EQUIP_NAME").toString());//设备编码
    		equipLog.setDescription_s(item.get("DESCRIPTION").toString());//设备名称
    		equipLog.setProductionline_code_s(productLineName);//父设备-产线
    		equipLog.setEquip_type_s(item.get("EQUIP_TYPE_S").toString());//设备类型
    		if(item.get("IP_ADDRESS_S")!=null){
    			equipStatus.setIp_address_s(item.get("IP_ADDRESS_S").toString());//设备IP
    		}
    		equipLog.setChangeby_s(LLWebUtils.getUser().userCode);//修改人
    		equipLog.setChangetime_t(new Date());//修改时间
    		equipLog.setRemark_s((LLConstant.Record_Flag.DELETED).concat(Process.HalfPart));
    		RockWellUtils.save(equipLog);
    	 }
  		
		return "success";
    }*/

}
