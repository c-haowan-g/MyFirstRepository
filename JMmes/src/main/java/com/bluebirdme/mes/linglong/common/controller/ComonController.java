/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.mes.linglong.common.service.CommonServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;


/**
 * 通用信息查询
 * @author 刘程明
 * @Date 2018-07-24 16:54:01
 */
@Log(code="COMMONZ_GETBANCI",value="通用信息查询日志")
@RestController
@RequestMapping("common")
public class ComonController extends RockWellFunctionalController<T> {
    
    @Resource CommonServiceImpl commonSrv;

    @Override
    protected RockWellBaseServiceImpl<T> getService() {
        return commonSrv;
    }
    @Log(code="COMMON_GETENTCODENAME",value="获取终检机台条码和名称对应关系")
    @RequestMapping("combox_entcode")
   	public String combox_entcode() throws Exception{
    	List<Map<String,Object>> list=commonSrv.getEntCodeName();
   		return toJson(list);
   	}
    @Log(code="comboxUser",value="查询用户信息")
    @RequestMapping("comboxUser")
   	public String comboxUser() throws Exception{
    	List<Map<String,Object>> list=commonSrv.getComboxUser();
   		return toJson(list);
   	}
    @Log(code="COMMON_GETBURINGENTCODENAME",value="获取硫化机台条码和名称对应关系")
    @RequestMapping("combox_buringentcode")
   	public String combox_buringentcode() throws Exception{
    	List<Map<String,Object>> list=commonSrv.getCombox_BuringEntCode();
   		return toJson(list);
   	}
    @Log(code="WGName",value="查询外观设备信息",target = LogType.CONSOLE)
    @RequestMapping("wgentInfo")
   	public String getEnttypeName(String enttype) throws Exception{
    	List<Map<String,Object>> list=commonSrv.getEnttypeName(enttype);
   		return toJson(list);
   	}
    
    @Log(code="COMMON_MATERIAL_VERSION",value="根据物料查询版本",target = LogType.CONSOLE)
    @RequestMapping("material/version")
    public String getProductVersionByMaterialCode(String materialCode){
    	List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
    	List<Object> vers=commonSrv.getProductVersionByMaterialCode(materialCode);
    	Map<String,Object> map=new HashMap<String, Object>();
    	for(Object o:vers){
    		map=new HashMap<String, Object>();
    		map.put("value", o);
    		map.put("text", o);
    		list.add(map);
    	}
    	return toJson(list);
    }
}
