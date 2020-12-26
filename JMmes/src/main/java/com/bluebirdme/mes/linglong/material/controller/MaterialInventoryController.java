/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;









import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.bluebirdme.mes.linglong.material.entity.MaterialInventory;
import com.bluebirdme.mes.linglong.material.service.MaterialInventoryServiceImpl;


/**
 * 原材料库存表
 * @author 李德晓
 * @Date 2020-08-06 12:12:08
 */
@Log(code="原材料库存表",value="原材料库存表")
@RestController
@RequestMapping("material/baseDate/materialinventory")
public class MaterialInventoryController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialInventoryServiceImpl materialinventorySrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialinventorySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialinventorySrv;
	}
    
    @Log(code="原材料库存表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        materialinventorySrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Override
    @Log(value = "信息列表查询", code = "信息列表查询", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map<String, String> map = filter.getFilter();
        if (null == map.get("product_time_t") && null == map.get("in_time_t")) {
          map.remove("start_time");
          map.remove("end_time");
        } 
        if (null == map.get("validSign") || "".equals(map.get("validSign")) || "all".equals(map.get("validSign"))) {
          map.remove("validSign");
          map.remove("expiredDay");
        } 
        if (null != map.get("validSign") && "expired".equals(map.get("validSign"))) {
          map.remove("validSign");
          String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
          map.put("expiry_date_t", dateNow);
          map.remove("expiredDay");
        } 
        if (null != map.get("validSign") && "recent".equals(map.get("validSign"))) {
          map.remove("validSign");
          Object o = map.get("expiredDay");
          map.remove("expiredDay");
          String future = LocalDateTime.now().plusDays(Long.valueOf((String)o).longValue()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
          map.put("expired_day", future);
        } 
        filter.setFilter(map);
        String supplier_lot_no_s = filter.get("supplier_lot_no_s");
        String lot_no_s = filter.get("lot_no_s");
        if (supplier_lot_no_s != null) {
          Filter filter1 = new Filter();
          filter1.set("supplier_lot_no_s", supplier_lot_no_s);
          return GsonTools.toJson(this.materialinventorySrv.datagridUDA(filter1, page));
        } 
        return GsonTools.toJson(this.materialinventorySrv.datagridUDA(filter, page));
      }
		/*return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}*/
    /**
     * 获取库区名称显示在下拉选中
     * @param store_type_s
     * @return
     */
    @RequestMapping({"findStorageMaterial"})
    public String findStorageMaterial(String store_type_s) throws Exception {
      List<Map<String, Object>> getStoreUnitlist = this.materialinventorySrv.findStorageMaterial(store_type_s);
      return toJson(getStoreUnitlist);
    }
    /**
     * 获取库位名称显示在下拉选
     * @param store_type_s
     * @return
     */
    @RequestMapping({"getStoreUnit"})
    public String getStoreUnit(String store_type_s) throws Exception {
      List<Map<String, Object>> getStoreUnitlist = this.materialinventorySrv.getStoreUnit(store_type_s);
      return toJson(getStoreUnitlist);
    }
    /**
     * 获取物料状态显示在下拉选
     * @param store_type_s
     * @param material_code_s
     * @return
     */
    @RequestMapping({"findStorageSupplier"})
    public String findStorageSupplier(String store_type_s, String material_code_s) throws Exception {
      List<Map<String, Object>> getStoreUnitlist = this.materialinventorySrv.findStorageSupplier(store_type_s, material_code_s);
      return toJson(getStoreUnitlist);
    }
    @Log(value = "原材料库存日志", code = "原材料库存日志", target = LogType.CONSOLE)
    		  @RequestMapping({"datagridhis"})
    		  public String datagridhis(Filter filter, Page page) throws Exception {
    		    Map<String, String> map = filter.getFilter();
    		    if (null == map.get("product_time_t") && null == map.get("in_time_t")) {
    		      map.remove("start_time");
    		      map.remove("end_time");
    		    } 
    		    if (null == map.get("validSign") || "".equals(map.get("validSign")) || "all".equals(map.get("validSign"))) {
    		      map.remove("expiredDay");
    		      map.remove("validSign");
    		    } 
    		    if (null != map.get("validSign") && "expired".equals(map.get("validSign"))) {
    		      map.remove("validSign");
    		      String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    		      map.put("expiry_date_t", dateNow);
    		      map.remove("expiredDay");
    		    } 
    		    if (null != map.get("validSign") && "recent".equals(map.get("validSign"))) {
    		      map.remove("validSign");
    		      Object o = map.get("expiredDay");
    		      map.remove("expiredDay");
    		      String future = LocalDateTime.now().plusDays(Long.valueOf((String)o).longValue()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    		      map.put("expired_day", future);
    		    } 
    		    filter.setFilter(map);
    		    String supplier_lot_no_s = filter.get("supplier_lot_no_s");
    		    String lot_no_s = filter.get("lot_no_s");
    		    if (supplier_lot_no_s != null) {
    		      Filter filter1 = new Filter();
    		      filter1.set("supplier_lot_no_s", supplier_lot_no_s);
    		      return GsonTools.toJson(this.materialinventorySrv.datagridhis(filter1, page, MaterialInventory.class));
    		    } 
    		    return GsonTools.toJson(this.materialinventorySrv.datagridhis(filter, page, MaterialInventory.class));
    		  }
    		  
}
