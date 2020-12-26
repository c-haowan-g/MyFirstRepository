/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.SapReturnResultSimple;
import com.bluebirdme.mes.linglong.curing.entity.WorkOrderQuota;
import com.bluebirdme.mes.linglong.curing.entity.WorkOrderResultPrint;

/**
 * 硫化工单生产实绩表
 * @author 周志祥
 * @Date 2018-11-10 11:17:18
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WorkOrderQuotaServiceImpl extends RockWellBaseServiceImpl<WorkOrderQuota> {
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return WorkOrderResultPrint.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    /**
	 * 查询硫化产量数据
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public List<SapReturnResultSimple> selectWorkOrderData(Map<String, Object> map) throws Exception {
		
    	String begin_created_time=map.get("begin_created_time").toString();
    	String end_created_time=map.get("end_created_time").toString();
    	String material_code_s=map.get("material_code_s").toString();
    	String equip_code_s=map.get("equip_code_s").toString();
    	String change=map.get("change").toString();
    	String[]type=change.split("_");
    	boolean equipcodeBool=false;
    	boolean materialBool=false;
    	boolean curingwordidBool=false;
    	for(int i=0;i<type.length;i++){
    		if(type[i].endsWith("1")){
    			equipcodeBool=true;
    		}else if(type[i].endsWith("2")){
    			materialBool=true;
    		}else if(type[i].endsWith("3")){
    			curingwordidBool=true;
    		}
    	}
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(" select max(a.atr_key) as atr_key,substr(a.equip_code_s, 4, 3) as equip_code_s, count(1) as totalquantity, count(1) as qualitycompletionrate,");
		if(materialBool){
			stringBuffer.append(" a.material_code_s,");
			stringBuffer.append(" a.material_name_s,");
		}else{
			stringBuffer.append(" max(a.material_code_s) material_code_s,");
			stringBuffer.append(" max(a.material_name_s) material_name_s,");
		}
		if(curingwordidBool){
			stringBuffer.append("  d.username username,");
		}else{
			stringBuffer.append(" max(d.username) username,");
		}
		stringBuffer.append(" count(1) as qualitycompletionrate,sum(decode(b.atpresentgradecode_s, '253007', 1, 0)) gradea,sum(decode( b.atpresentgradecode_s, '253008', 1, 0)) gradea0,sum(decode( b.atpresentgradecode_s, '253006', 1, 0)) secondlevel,sum(decode( b.atpresentgradecode_s, '253012', 1, 0)) waste,sum(decode( b.atpresentgradecode_s, '253013', 1, 0)) specialwaste ");
		stringBuffer.append(" from at_c_mm_workorderresult a, core_user d,at_c_mm_curing_maintyre b where a.created_by_s = d.usercode(+) and a.tyre_barcode_s = b.TyreBarCode_S(+)");
		stringBuffer.append("  and a.CURING_OPENMOULDDATE_T BETWEEN to_date  ('" + begin_created_time + "','yyyy-MM-dd HH24:mi:ss') " + "AND to_date('"+ end_created_time + "','yyyy-MM-dd HH24:mi:ss')");
		stringBuffer.append(" and a.s_factory_s="+LLWebUtils.factory());
		stringBuffer.append(" and b.Proess_S='252006'");
		if(equip_code_s!=""&&equip_code_s!=null){
			stringBuffer.append(" and a.equip_code_s like '%"+equip_code_s+"%'");
		}
		if(materialBool&&material_code_s!=""){
			stringBuffer.append(" and material_code_s like '%"+material_code_s+"%'");
		}
		stringBuffer.append(" group by  substr(a.equip_code_s, 4, 3)");
		if(materialBool){
			stringBuffer.append(" , a.MATERIAL_CODE_S");
			stringBuffer.append(" , a.MATERIAL_NAME_S");
		}
		if(curingwordidBool){
			stringBuffer.append(" , d.username");
		}
		stringBuffer.append(" order by substr(a.equip_code_s, 4, 3)");
		System.out.println(stringBuffer.toString());
		return createSQLQuery(stringBuffer.toString(), WorkOrderQuota.class).list();
	}
    

}
