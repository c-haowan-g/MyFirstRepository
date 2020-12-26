/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pnuts.xml.newDocument;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;







import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.material.entity.RawMaterialInventoryState;
import com.bluebirdme.mes.linglong.material.entity.RmMaterialApply;
import com.bluebirdme.mes.linglong.material.entity.TestTaskDenial;
import com.bluebirdme.mes.linglong.material.service.RmMaterialApplyServiceImpl;
import com.bluebirdme.mes.linglong.mix.entity.MaterialApply;
import com.bluebirdme.mes.linglong.mix.service.MaterialApplyServiceImpl;


/**
 * 原材料领料计划主表
 * @author 李昂
 * @Date 2020-09-25 16:35:58
 */
@Log(code="AT_RM_PP_MATERIALAPPLY",value="原材料领料计划主表")
@RestController
@RequestMapping("material/plans/materialApply/rmMaterial")
public class RmMaterialApplyController extends RockWellFunctionalUDAController<Object> {
    
    @Resource RmMaterialApplyServiceImpl rmmaterialapplySrv;
    
    @Resource MaterialApplyServiceImpl mixmaterialApplySrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return rmmaterialapplySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return rmmaterialapplySrv;
	}
    
    @Log(code="AT_RM_PP_MATERIALAPPLY_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        rmmaterialapplySrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    
    @ResponseBody
    @RequestMapping("createTodayPlan")
    public String createTodayPlan(@RequestParam("planDate")String planDate,@RequestParam("sfactory")String sfactory,HttpServletRequest request,
            HttpServletResponse response, Filter filter, Page page) throws Exception{
    		filter.set("prod_date_s", planDate);
    		//filter.set("spare3_s", "005006");
    		filter.set("spare1_s","1");
    		filter.set("s_factory_s",sfactory);
    		Map map=mixmaterialApplySrv.datagrid(filter, page,MaterialApply.class);
    		List<MaterialApply> list =(List<MaterialApply>)map.get("rows");
    		List<MaterialApply> resultlist=new ArrayList<MaterialApply>();
    		resultlist.add(list.get(0));
    		
    		for(int i=1;i<list.size();i++){
    			MaterialApply centerApply=list.get(i);
    			for(int j=0;j<resultlist.size();j++){
    				if(centerApply.getMaterial_code_s().equals(resultlist.get(j).getMaterial_code_s())){
    					Double a=Double.parseDouble(resultlist.get(j).getQty_apply_f())+Double.parseDouble(centerApply.getQty_apply_f());
    					resultlist.get(j).setQty_apply_f(a+"");
    					centerApply=null;
    					System.out.println(resultlist.get(j).getQty_apply_f());
    					break;
    					
    				}
    			}
    			if (centerApply!=null) {
					resultlist.add(centerApply);
				}
    			
    		}
    		System.out.println(resultlist.get(0).getSpare3_s()+"");
    		List<RmMaterialApply> saveList=new ArrayList<RmMaterialApply>();
    		RmMaterialApply rmMA=new RmMaterialApply();
    		for(int k=0;k<resultlist.size();k++){
    			if(resultlist.get(k).getSpare3_s().equals("005006")){
    				
    				rmMA.setData_source_s("0");
    				rmMA.setMaterial_code_s(resultlist.get(k).getMaterial_code_s());
    				rmMA.setMaterial_name_s(resultlist.get(k).getMaterial_name_s());
    				rmMA.setProd_date_s(resultlist.get(k).getProd_date_s());
    				rmMA.setQty_apply_f(resultlist.get(k).getQty_apply_f());
    				rmMA.setQty_receive_f("0.0");
    				rmMA.setSpare1_s(resultlist.get(k).getSpare3_s());
    				rmMA.setSpare2_s("012001");
    				rmMA.setStore_type_s("炭黑库");
    				rmMA.setS_factory_s(resultlist.get(k).getS_factory_s());
    				saveList.add(rmMA);
    				rmMA=null;
    			}else if(resultlist.get(k).getSpare3_s().equals("005013")){
    				
    				rmMA.setData_source_s("0");
    				rmMA.setMaterial_code_s(resultlist.get(k).getMaterial_code_s());
    				rmMA.setMaterial_name_s(resultlist.get(k).getMaterial_name_s());
    				rmMA.setProd_date_s(resultlist.get(k).getProd_date_s());
    				rmMA.setQty_apply_f(resultlist.get(k).getQty_apply_f());
    				rmMA.setQty_receive_f("0.0");
    				rmMA.setSpare1_s(resultlist.get(k).getSpare3_s());
    				rmMA.setSpare2_s("012001");
    				rmMA.setStore_type_s("炭黑库");
    				rmMA.setS_factory_s(resultlist.get(k).getS_factory_s());
    				saveList.add(rmMA);
    				rmMA=null;
    			}else if(resultlist.get(k).getSpare3_s().equals("005009")){
    				rmMA.setData_source_s("0");
    				rmMA.setMaterial_code_s(resultlist.get(k).getMaterial_code_s());
    				rmMA.setMaterial_name_s(resultlist.get(k).getMaterial_name_s());
    				rmMA.setProd_date_s(resultlist.get(k).getProd_date_s());
    				rmMA.setQty_apply_f(resultlist.get(k).getQty_apply_f());
    				rmMA.setQty_receive_f("0.0");
    				rmMA.setSpare1_s(resultlist.get(k).getSpare3_s());
    				rmMA.setSpare2_s("012002");
    				rmMA.setStore_type_s("烘胶房-线边库");
    				rmMA.setS_factory_s(resultlist.get(k).getS_factory_s());
    				saveList.add(rmMA);
    				rmMA=null;
    			}else if((resultlist.get(k).getSpare3_s().equals("005007")||resultlist.get(k).getSpare3_s().equals("005008")) && resultlist.get(k).getEquip_name_s().equals("M1-自动配料-辅料-1#") ){
    				rmMA.setData_source_s("0");
    				rmMA.setMaterial_code_s(resultlist.get(k).getMaterial_code_s());
    				rmMA.setMaterial_name_s(resultlist.get(k).getMaterial_name_s());
    				rmMA.setProd_date_s(resultlist.get(k).getProd_date_s());
    				rmMA.setQty_apply_f(resultlist.get(k).getQty_apply_f());
    				rmMA.setQty_receive_f("0.0");
    				rmMA.setSpare1_s(resultlist.get(k).getSpare3_s());
    				rmMA.setSpare2_s("012004");
    				rmMA.setStore_type_s("自动配料-1#");
    				rmMA.setS_factory_s(resultlist.get(k).getS_factory_s());
    				saveList.add(rmMA);
    				rmMA=null;
    			}else if((resultlist.get(k).getSpare3_s().equals("005007")||resultlist.get(k).getSpare3_s().equals("005008")) && !resultlist.get(k).getEquip_name_s().equals("M1-自动配料-辅料-1#") ){
    				rmMA.setData_source_s("0");
    				rmMA.setMaterial_code_s(resultlist.get(k).getMaterial_code_s());
    				rmMA.setMaterial_name_s(resultlist.get(k).getMaterial_name_s());
    				rmMA.setProd_date_s(resultlist.get(k).getProd_date_s());
    				rmMA.setQty_apply_f(resultlist.get(k).getQty_apply_f());
    				rmMA.setQty_receive_f("0.0");
    				rmMA.setSpare1_s(resultlist.get(k).getSpare3_s());
    				rmMA.setSpare2_s("012005");
    				rmMA.setStore_type_s("自动配料-2#");
    				rmMA.setS_factory_s(resultlist.get(k).getS_factory_s());
    				saveList.add(rmMA);
    				rmMA=null;
    			}
    		}
    		for(int l=0;l<saveList.size();l++){
    			Filter filter3=new Filter();
    			filter3.set("material_code_s",saveList.get(l).getMaterial_code_s());
    			filter3.set("prod_date_s",saveList.get(l).getProd_date_s());
    			filter3.set("s_factory_s",saveList.get(l).getS_factory_s());
    			Map map2=rmmaterialapplySrv.datagrid(filter3, page, RmMaterialApply.class);
    			List<RmMaterialApply> list2 =(List<RmMaterialApply>)map2.get("rows");
    			if(list2.size()<1){
    				rmmaterialapplySrv.save(saveList.get(l));
    			}
    			
    		}
    		
    		
    		
    
        return null;
    }
    
    

}
