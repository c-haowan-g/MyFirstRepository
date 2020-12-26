/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;








import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.FeedrecordServiceImpl;


/**
 * 投料记录
 * @author 徐秉正
 * @Date 2020-03-23 13:42:36
 */
@Log(code="feedrecord",value="投料维护")
@RestController
@RequestMapping("halfpart/feedrecord/feedrecord")
public class FeedrecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource FeedrecordServiceImpl feedrecordSrv;

    
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return feedrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return feedrecordSrv;
	}
    
    @Log(code="feedrecord_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    	 if (feedrecordSrv.saveChanges(rockWellEntityDTO) == -1) {
 			return Response.error(Response.SYS_EXCEPTION, "代码重复",rockWellEntityDTO);
 		}
        return Response.suc();
    }
    /**
	 * 
	 * 查出所需要的全钢物料
	 * 
	 * @return
	 * @throws Exception
	 */
		@Log(code = "materialGroupList", value = "产出所需要的全钢物料")
		@RequestMapping("materialGroupList")
		public String materialGroupList() throws Exception {
			List<Map<String, Object>> list = feedrecordSrv.materialGroupList();
			return toJson(feedrecordSrv.materialGroupList());
		}
		
		//子弹窗保存物料组查询
		 /**
		 * 
		 * 查出所需要的全钢物料
		 * 
		 * @return
		 * @throws Exception
		 */
			@Log(code = "materialGroupSearch", value = "产出所需要的全钢物料")
			@RequestMapping("materialGroupSearch")
			public String materialGroupSearch(String data) throws Exception {
				//List<Map<String, Object>> list = feedrecordSrv.materialGroupSearch();
				return toJson(feedrecordSrv.materialGroupSearch(data));
			}
		//查询产线
		@RequestMapping("getHalfPartProductionLine")
	 	public String getHalfPartProductionLine() throws Exception{
			List<String> list=feedrecordSrv.getHalfPartProductionLine();
			return toJson(list);
	 	}
		//查询当天日计划号
		@RequestMapping("getPlanno")
	 	public String getPlanno() throws Exception{
			List<Map<String, Object>> list=feedrecordSrv.getPlanno();
			return toJson(list);
	 	}
		
		/**
		 * 查出物料组显示在JSP页面下拉列表处
		 * 
		 * @return
		 */
		@Log(code = "searchMaterialGroup", value = "查出物料组显示在JSP页面下拉列表处")
		@RequestMapping("searchMaterialGroup")
		public String searchMaterialGroup() throws Exception {
			List<Map<String, Object>> list = feedrecordSrv.searchMaterialGroup();
			return toJson(list);
		}
		/**
		 * 根据物料组编号查询物料组名称
		 * 
		 * @return
		 */
		@Log(code = "getNameByGroupCode", value = "根据物料组编号查询物料组名称")
		@RequestMapping("getNameByGroupCode")
		public String getNameByGroupCode(String materialgroup_s) throws Exception {
			List<Map<String, Object>> list = feedrecordSrv.getNameByGroupCode(materialgroup_s);
			return toJson(list);
		}
		/**
		 * 根据用户号码查询姓名
		 * 
		 * @return
		 */
		@Log(code = "toUserName", value = "根据用户号码查询姓名")
		@RequestMapping("toUserName")
		public String toUserName(String usercode) throws Exception {
			List<Map<String, Object>> list = feedrecordSrv.toUserName(usercode);
			return toJson(list);
		}
		
		/**
		 * 根据机台编码查询机台名称
		 * 
		 * @return
		 */
		@Log(code = "toEquipName", value = "根据机台编码查询机台名称")
		@RequestMapping("toEquipName")
		public String toEquipName(String equipcode) throws Exception {
			List<Map<String, Object>> list = feedrecordSrv.toEquipName(equipcode);
			return toJson(list);
		}
		
	
}










