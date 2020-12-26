package com.bluebirdme.mes.linglong.halfpart.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.halfpart.entity.Carinfo;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartUnit;
import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartUnitDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.StockMapAll;
import com.bluebirdme.mes.linglong.halfpart.entity.Stockmap;
import com.bluebirdme.mes.linglong.halfpart.service.HalfPartUnitServiceImpl;


@Log(code = "SUnit", value = "库位操作日志")
@RestController
@RequestMapping("halfpart/basedata/storageunitmanager")
public class HalfPartUnitController extends FunctionalController<HalfPartUnit> {
    
    @Resource HalfPartUnitServiceImpl stoUnitSrv;
	@Override
	protected HalfPartUnitServiceImpl getService() {
		return stoUnitSrv;
	}
	@Log(code="StorageUnit_Save",value="保存库区数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody HalfPartUnitDTO storageUnitDTO ) throws Exception {
        return Response.suc(stoUnitSrv.saveChanges(storageUnitDTO));
    }
    
	/**
	 * 获取库位信息
	 * 李新宇
	 * 2019年4月17日
	 * @param plinekey 库区ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("unit")
	public String unit(String zonekey,String materialGroup) throws Exception{
		return toJson(stoUnitSrv.getUnit(zonekey,materialGroup));
	}
    
	/**
	 * 初始化数据使用，不对外使用
	 * 李新宇
	 * 2019年4月17日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("initializateStorageUnits")
	public void initializateStorageUnits() throws Exception{
		String areaName="80032B";
		String storageZoneName= "StorageZoneBGIn";
		String storageUnitType= "161001";
		String unitDescription= null;
		stoUnitSrv.initializateStorageUnits(areaName,storageZoneName,storageUnitType,unitDescription);
	}
	
	/**
	 * 根据库区key获得物料组
	 * 李新宇
	 * 2019年4月17日
	 */
	@RequestMapping("searchMaterialGroupByZoneKey")
	public String searchMaterialGroupByZoneKey(String zonekey)throws Exception{
		return toJson(stoUnitSrv.searchMaterialGroupByZoneKey(zonekey));
	}
	
	/**
	 * 前台获取category生成库位名称
	 * 李新宇
	 * 2019年4月17日
	 */
	@RequestMapping("createUnitName")
	public String createUnitName(String materialGroup,String category)throws Exception{
		String unitCode=stoUnitSrv.createUnitName(materialGroup,category);
		return toJson(unitCode);
	}
	
	/**
	 * 通过传库区条码获取库位信息
	 * 葛迎祥
	 * 2020年7月22日
	 */
	@RequestMapping({ "getZoneList" })
	public String getZoneList(String zonekey) throws Exception {
		List<Map<String, Object>> listMap = this.stoUnitSrv.getUnit(zonekey,null);
		if ((listMap == null) || (listMap.size() == 0)) {
			return null;
		}
		Stockmap map = new Stockmap();
		String resultStr = "<div>";
		for (int i = 0; i < listMap.size(); i++) {
			StockMapAll data = new StockMapAll();
			// 库位名称
			data.setS_storeloc(((Map) listMap.get(i)).get("storage_unit_name").toString());
			// 工装载具
			List<Map<String, Object>> vehiclesList = this.stoUnitSrv.findVechineByZone(((Map) listMap.get(i)).get("storage_unit_name").toString());
			Date nowdate = new Date();
			long nowtime = nowdate.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (vehiclesList.size() > 0) {
				ArrayList<Carinfo> carsList = new ArrayList();
				for (int j = 0; j < vehiclesList.size(); j++) {
					String equipcode = ((Map) vehiclesList.get(j)).get("equip_code_s").toString();
					if ((!StringHelper.isNullOrEmpty(equipcode)) && (equipcode.length() >= 6)) {
						equipcode = equipcode.substring(3, 6);
					}
					Date olddate = sdf.parse(((Map) vehiclesList.get(j)).get("created_time_t").toString());
					long oldtime = olddate.getTime();
					long between_hour = (nowtime - oldtime) / 3600000L;
					boolean isgq = true;
					if (((Map) vehiclesList.get(j)).get("gqtime") != null) {
						long gqtime = Long.parseLong(((Map) vehiclesList.get(j)).get("gqtime").toString());
						if (between_hour < gqtime) {
							isgq = false;
						}
					}
					Carinfo carinfo = new Carinfo(((Map) vehiclesList.get(j)).get("barcode_s").toString(), equipcode,
							((Map) vehiclesList.get(j)).get("created_by_s").toString(), ((Map) vehiclesList.get(j))
							.get("l_num_f").toString(), between_hour+ "", ((Map) vehiclesList.get(j)).get("materielname_s").toString(),
							Boolean.valueOf(isgq));
					carsList.add(carinfo);
				}
				data.setS_storespec(((Map) vehiclesList.get(0)).get("materielname_s").toString());
				data.setS_storecarnum(vehiclesList.size());
				data.setCarsList(carsList);
			}
			if (StringHelper.isNullOrEmpty(data.getS_storespec())) {
				data.setS_storespec("无");
			}
			resultStr = resultStr + map.geth(data);
		}
		resultStr = resultStr + "</div>";
		System.out.println(resultStr);
		return toJson(resultStr);
	}
	
}
