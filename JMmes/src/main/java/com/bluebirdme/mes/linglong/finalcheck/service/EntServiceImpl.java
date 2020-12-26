/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

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

import com.bluebird.clientdata.WriteTagData;
import com.bluebird.clientdata.WriteTagResult;
import com.bluebird.clientproxy.LineTagDataProxy;
import com.bluebirdme.core.system.constants.SessionConstant;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Ent;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.EntDTO;

/**
 * 质检设备信息表
 * @author 司乔靖
 * @Date 2018-08-10 07:56:16
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EntServiceImpl extends RockWellBaseServiceImpl<Ent> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Ent.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    /**
     * 保存方法
     * @param ent 机台实体类
     * @throws Exception
     */
    @RockWellTransactional
    public void saveChanges(EntDTO ent) throws Exception{
        if (!ListUtils.isEmpty(ent.getDeleted())) {
        	delete(ent.getDeleted());
        	
        }
        if (!ListUtils.isEmpty(ent.getInserted())) {
        	List<Ent> entList = ent.getInserted();
        	for(Ent item:entList)
        	{
        		item.setS_factory_s(LLWebUtils.factory());
        		item.setCreated_by_s(LLWebUtils.getUser().userCode+LLWebUtils.getUser().userName);
        		item.setCreated_time_t(new Date());
        		item.setRecord_flag_s("A");
        		item.setArch_flag_s("0");
        		item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
        		if(item.getEnttype_i().equals("254002")){
        			changeTagStatus(item.getEntbarcode_s(),item.getSpare2_s());
        		}
        	}
            save(entList);
            
        }
        if (!ListUtils.isEmpty(ent.getUpdated())) {
        	List<Ent> entList = ent.getUpdated();
        	for(Ent item:entList)
        	{
        		item.setChanged_by_s(LLWebUtils.getUser().userCode+LLWebUtils.getUser().userName);
        		item.setChanged_time_t(new Date());
        		if(item.getEnttype_i().equals("254002")){
        			changeTagStatus(item.getEntbarcode_s(),item.getSpare2_s());
        		}
        	}
            update(entList);
        }
    }
    /**
     * 外观机台保存是否强制下发信息至tag点
     * @param entcode 机台条码
     * @param status 状态，0：否，1:是
     * @throws Exception
     */
    private void changeTagStatus (String entcode,String status) throws Exception{
    	if(status==""||entcode==""){
    		throw new Exception("机台信息或状态缺失");
    	}
    	String webServiceAddress = "http://192.168.55.43:11201/winceService?wsdl";// 全钢分发服务地址
		LineTagDataProxy lineTagDataProxy = new LineTagDataProxy(webServiceAddress, entcode);
		WriteTagData writeTagData = new WriteTagData();
		writeTagData.setLogicalAddress("MesToPlcOnLine");
		writeTagData.setTagValue(status);
		List<WriteTagData> listDate=new ArrayList<>();
		listDate.add(writeTagData);
		try {
			 List<WriteTagResult> list=lineTagDataProxy.writeTagDataListToPLC(entcode, listDate);
			if(list.size()==0||list==null){
				throw new Exception("下发信息至Tag点(MesToPlcOnLine)失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    /**
     * 
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> entBarcodeExit(String entbarcode_sString) throws Exception
    {
 	    String factoryString=LLWebUtils.factory();
     	String agenc_no_sString =FactoryConstant.JING_MEN_CODE;
    	SQLQuery query=createSQLQuery(getSQL("entBarcodeExit"));
    	query.setParameter("s_factory_s", factoryString);
     	query.setParameter("agenc_no_s",agenc_no_sString);//
     	query.setParameter("entbarcode_s",entbarcode_sString);
    	List<Map<String, Object>> list=query.list();
	    return list;
    }
    /**
     * 强制开启关闭操作方法
     * @param ids 界面操作的行ID
     * @throws Exception 
     */
    public void forced(Long[] ids,String foreType) throws Exception {
		/*for(int i=0;i<ids.length;i++){
			Ent ent=findById(ids[i]);
			changeTagStatus(ent.getEntbarcode_s(),foreType);
			String name=LLWebUtils.getUser().userCode+LLWebUtils.getUser().userName;
			update(ids[i], "spare2_s", foreType);
		}*/
		List<Ent> listEnt=	findByIds(ids);
		for(Ent item:listEnt)
		{
			item.setChanged_by_s(LLWebUtils.getUser().userCode+LLWebUtils.getUser().userName);
			item.setChanged_time_t(new Date());
			changeTagStatus(item.getEntbarcode_s(),foreType);
			item.setSpare2_s(foreType);
			update(item);
		}
	}
}
