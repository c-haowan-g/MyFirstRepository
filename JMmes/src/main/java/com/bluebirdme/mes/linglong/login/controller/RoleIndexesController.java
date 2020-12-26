package com.bluebirdme.mes.linglong.login.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebirdme.core.system.base.BaseController;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.login.entity.RoleIndexes;
import com.bluebirdme.mes.linglong.login.service.RoleIndexesServiceImpl;

/**
 * 
 * @author Goofy
 * @Date 2019年4月2日 下午12:24:34
 */
@Controller
@RequestMapping("/role/indexes")
public class RoleIndexesController extends FunctionalController<RoleIndexes> {
	
	@Resource
	RoleIndexesServiceImpl riSrv;

	@Override
	protected BaseServiceImpl<RoleIndexes> getService() {
		return riSrv;
	}
	
	@ResponseBody
	@RequestMapping("save2")
	public Response save2(@RequestBody List<RoleIndexes> list){
		riSrv.delete("roleId", list.get(0).getRoleId());
		riSrv.save(list);
		return Response.suc();
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Response getIndexs(Long roleId){
		return Response.suc(riSrv.findByField("roleId", roleId));
	}
	
	
	
}
