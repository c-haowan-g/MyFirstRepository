/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.login.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.ext.HttpUtils;
import org.xdemo.app.xutils.j2se.DateUtils;
import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.MD5Utils;

import com.bluebirdme.core.common.entity.Menu;
import com.bluebirdme.core.common.entity.User;
import com.bluebirdme.core.common.entity.UserRole;
import com.bluebirdme.core.common.service.PermissionServiceImpl;
import com.bluebirdme.core.common.service.UserRoleServiceImpl;
import com.bluebirdme.core.common.service.UserServiceImpl;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseController;
import com.bluebirdme.core.system.constants.SessionConstant;
import com.bluebirdme.core.system.constants.SystemConstant;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.login.entity.OtherLogin;
import com.bluebirdme.mes.linglong.login.service.RoleIndexesServiceImpl;
import com.bluebirdme.mes.linglong.pda.entity.ModifyPassword;
import com.google.common.collect.Sets;
import com.jcraft.jsch.Session;

/**
 * 其他系统获取权限登录
 * @author lcm
 * @Date 2019年1月11日 下午15:37:28
 */
@RestController
@RequestMapping("/login")
public class OtherLoginController extends BaseController {
	
	@Resource UserServiceImpl userSrv;
	
	@Resource PermissionServiceImpl permissionSrv;
	@Resource RoleIndexesServiceImpl indexSrv;
	@Resource UserRoleServiceImpl urSrv;
	
	@NoLogin
	@Log(value="校验用户名密码，返回所有信息",code="ALL_LOGIN",target=LogType.DB)
	@RequestMapping("loadall") //默认支持POST，GET
	public Response loadall(@RequestBody OtherLogin otherLogin) throws Exception{
		if(otherLogin.getFormtype().isEmpty()){
			return Response.error(Response.SYS_EXCEPTION, "无界面类型信息", null);
		}
		LanguageProvider.setLanguage(otherLogin.getLanguage());
		User user = userSrv.unique("userCode", otherLogin.getCode());
		String md5_password = MD5Utils.md5(otherLogin.getPassword(), SystemConstant.SYS_MD5_SALT);
        //校验用户名密码
		if (user == null || !user.getUserPassword().equals(md5_password)) {
			return Response.error(Response.SYS_EXCEPTION,LanguageProvider.getMessage("tip.incorrect"),null);
		}
		if (user.getAccountState().equals("锁定")) {
			return Response.error(Response.SYS_EXCEPTION,LanguageProvider.getMessage("tip.locked"),null);
		}
		//用户名密码校验成功后->保存登录信息
		session.setAttribute(SessionConstant.USER_ID, user.getId());
		session.setAttribute(SessionConstant.USER_NAME, user.getUserName());
		session.setAttribute(SessionConstant.USER, user);
		session.setAttribute(SessionConstant.FACTORY, otherLogin.getFactory());
		user.setLastLoginDate(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
		user.setLastLoginIP(HttpUtils.getIpAddr(request));
		userSrv.update(user);
		// 登陆成功后->查询用户权限信息
		List<Menu> list=permissionSrv.permission(WebUtils.getUserId(),otherLogin.getFormtype());
		Set<String> buttons=Sets.newConcurrentHashSet();
		for(int i=list.size()-1;i>=0;i--){
			if(list.get(i).getFactory()!=null&&list.get(i).getFactory()==0){
				continue;
				
			}else{
				if(list.get(i).getFactory()==null||!otherLogin.getFactory().equals(list.get(i).getFactory().toString())){
					list.remove(i);//校验请求的工厂信息
					continue;
				}
			}
			if(list.get(i).getType()==3){
				buttons.add(list.get(i).getCode());
			}
		}
		session.setAttribute(SessionConstant.USER_PERMISSION, buttons);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("session", session.getId());
		map.put("menus", list);
		map.put("uid", user.getId());
		map.put("userCode", user.getUserCode());
		map.put("userName", user.getUserName());
		List<UserRole> urList=urSrv.findByField("userId", user.getId());
		if(ListUtils.isEmpty(urList)){
			map.put("indexes",indexSrv.getIndexes(-1L));
		}else{
			map.put("indexes",indexSrv.getIndexes(urList.get(0).getRoleId()));
		}
		//返回权限信息
		return Response.suc(map);
	}
	@NoLogin
	@Log(value="校验用户名密码，返回页面的权限信息",code="FORM_LOGIN",target=LogType.DB)
	@RequestMapping("loadform") //默认支持POST，GET
	public Response loadform(@RequestBody OtherLogin otherLogin) throws Exception{
		if(otherLogin.getFormtype().isEmpty()){
			return Response.error(Response.SYS_EXCEPTION, "无界面类型信息", null);
		}
		LanguageProvider.setLanguage(otherLogin.getLanguage());
		User user = userSrv.unique("userCode", otherLogin.getCode());
		String md5_password = MD5Utils.md5(otherLogin.getPassword(), SystemConstant.SYS_MD5_SALT);
        //校验用户名密码
		if (user == null || !user.getUserPassword().equals(md5_password)) {
			return Response.error(Response.SYS_EXCEPTION,LanguageProvider.getMessage("tip.incorrect"),null);
		}
		if (user.getAccountState().equals("锁定")) {
			return Response.error(Response.SYS_EXCEPTION,LanguageProvider.getMessage("tip.locked"),null);
		}
		//用户名密码校验成功后->保存登录信息
		session.setAttribute(SessionConstant.USER_ID, user.getId());
		session.setAttribute(SessionConstant.USER_NAME, user.getUserName());
		session.setAttribute(SessionConstant.USER, user);
		session.setAttribute(SessionConstant.FACTORY, otherLogin.getFactory());
		user.setLastLoginDate(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
		user.setLastLoginIP(HttpUtils.getIpAddr(request));
		userSrv.update(user);
		// 登陆成功后->查询用户权限信息
		List<Menu> list=permissionSrv.permission(WebUtils.getUserId(),otherLogin.getFormtype());
		Set<String> buttons=Sets.newConcurrentHashSet();
		for(int i=list.size()-1;i>=0;i--){
			if(list.get(i).getFactory()!=null&&list.get(i).getFactory()==0){
				continue;
				
			}else{
				if(list.get(i).getFactory()==null||!otherLogin.getFactory().equals(list.get(i).getFactory().toString())){
					list.remove(i);//校验请求的工厂信息
					continue;
				}
			}
			//清除按钮信息
			if(list.get(i).getType()==3){
				buttons.add(list.get(i).getCode());
				list.remove(i);
			}
		}
		session.setAttribute(SessionConstant.USER_PERMISSION, buttons);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("session", session.getId());
		map.put("menus", list);
		map.put("uid", user.getId());
		map.put("userCode", user.getUserCode());
		map.put("userName", user.getUserName());
		List<UserRole> urList=urSrv.findByField("userId", user.getId());
		if(ListUtils.isEmpty(urList)){
			map.put("indexes",indexSrv.getIndexes(-1L));
		}else{
			map.put("indexes",indexSrv.getIndexes(urList.get(0).getRoleId()));
		}
		//返回权限信息
		return Response.suc(map);
	}
	
	@NoLogin
	@Log(value="根据窗体ID返回按钮信息",code="LOGIN_BUTTON",target=LogType.DB)
	@RequestMapping("loadbutton") //默认支持POST，GET
	public Response loadbutton(@RequestBody OtherLogin otherLogin) throws Exception{
		
		if(otherLogin.getFormID().isEmpty()||otherLogin.getFormtype().isEmpty()){
			return Response.error(Response.SYS_EXCEPTION, "无界面ID或界面类型", null);
		}
		LanguageProvider.setLanguage(otherLogin.getLanguage());
		User user = userSrv.unique("userCode", otherLogin.getCode());
		String md5_password = MD5Utils.md5(otherLogin.getPassword(), SystemConstant.SYS_MD5_SALT);
        //校验用户名密码
		if (user == null || !user.getUserPassword().equals(md5_password)) {
			return Response.error(Response.SYS_EXCEPTION,LanguageProvider.getMessage("tip.incorrect"),null);
		}
		if (user.getAccountState().equals("锁定")) {
			return Response.error(Response.SYS_EXCEPTION,LanguageProvider.getMessage("tip.locked"),null);
		}
		//用户名密码校验成功后->保存登录信息
		session.setAttribute(SessionConstant.USER_ID, user.getId());
		session.setAttribute(SessionConstant.USER_NAME, user.getUserName());
		session.setAttribute(SessionConstant.USER, user);
		session.setAttribute(SessionConstant.FACTORY, otherLogin.getFactory());
		user.setLastLoginDate(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
		user.setLastLoginIP(HttpUtils.getIpAddr(request));
		userSrv.update(user);
		// 登陆成功后->查询用户权限信息
		List<Menu> list=permissionSrv.permission(WebUtils.getUserId(),otherLogin.getFormtype());
		Set<String> buttons=Sets.newConcurrentHashSet();
		for(int i=list.size()-1;i>=0;i--){
			//PID可能为空
			if(list.get(i).getPid()==null){
				list.remove(i);
				continue;
			}
			//过滤掉页面
			if(!list.get(i).getPid().toString().equals(otherLogin.getFormID())){
				list.remove(i);
				continue;
			}
			if(list.get(i).getFactory()!=null&&list.get(i).getFactory()==0){
				continue;
				
			}else{
				if(list.get(i).getFactory()==null||!otherLogin.getFactory().equals(list.get(i).getFactory().toString())){
					list.remove(i);//校验请求的工厂信息
					continue;
				}
			}
			//添加按钮信息
			if(list.get(i).getType()==3){
				buttons.add(list.get(i).getCode());
			}
		}
		session.setAttribute(SessionConstant.USER_PERMISSION, buttons);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("session", session.getId());
		map.put("menus", list);
		map.put("uid", user.getId());
		map.put("userCode", user.getUserCode());
		map.put("userName", user.getUserName());
		//返回权限信息
		return Response.suc(map);
	}
	
	@Log(value="修改密码",code="CHANGE_PASSWORD",target=LogType.DB)
	@RequestMapping(value="modifypassword",method = RequestMethod.POST)
	public Response modifypassword(@RequestBody ModifyPassword mp) throws NoSuchAlgorithmException{
		
		User u=WebUtils.getUser();
		u.setUserPassword(MD5Utils.md5(mp.getNewPassword(), SystemConstant.SYS_MD5_SALT));
		userSrv.update(u);
		
		return Response.suc();
	}
	
	@Log(value="用户退出登录",code="OUT_LOGIN",target=LogType.CONSOLE)
	@RequestMapping(value="logout",method = RequestMethod.GET)
	public Response logout() {
		if(!session.isNew()){
			session.invalidate();
		}
		return Response.suc();
	}

}
