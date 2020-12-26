/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.pda.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.HttpUtils;
import org.xdemo.app.xutils.j2se.DateUtils;
import org.xdemo.app.xutils.j2se.MD5Utils;

import com.alibaba.fastjson.JSON;
import com.bluebirdme.core.common.entity.Menu;
import com.bluebirdme.core.common.entity.User;
import com.bluebirdme.core.common.service.PermissionServiceImpl;
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
import com.bluebirdme.mes.linglong.pda.entity.HttpResult;
import com.bluebirdme.mes.linglong.pda.entity.Login;
import com.bluebirdme.mes.linglong.pda.entity.ModifyPassword;
import com.google.common.collect.Sets;

/**
 * PDA登录
 * 
 * @author Goofy
 * @Date 2018年8月5日 下午1:45:28
 */
@RestController
@RequestMapping("/pda")
public class PdaLoginController extends BaseController {

	@Resource
	UserServiceImpl userSrv;

	@Resource
	PermissionServiceImpl permissionSrv;

	@NoLogin
	@Log(value = "PDA用户登录", code = "PDA_LOGIN", target = LogType.DB)
	@RequestMapping("login")
	// 默认支持POST，GET
	public Response login(@RequestBody Login login) throws Exception {

		System.out.println("-----------" + "PDA登陆成功" + "---------------");
		LanguageProvider.setLanguage(login.getLanguage());

		User user = userSrv.unique("userCode", login.getCode());

		String md5_password = MD5Utils.md5(login.getPassword(), SystemConstant.SYS_MD5_SALT);

		if (user == null || !user.getUserPassword().equals(md5_password)) {
			return Response.error(Response.SYS_EXCEPTION, LanguageProvider.getMessage("tip.incorrect"), null);
		}

		if (user.getAccountState().equals("锁定")) {
			return Response.error(Response.SYS_EXCEPTION, LanguageProvider.getMessage("tip.locked"), null);
		}

		// 登陆成功后

		session.setAttribute(SessionConstant.USER_ID, user.getId());
		session.setAttribute(SessionConstant.USER_NAME, user.getUserName());
		session.setAttribute(SessionConstant.USER, user);
		session.setAttribute(SessionConstant.FACTORY, login.getFactory());

		user.setLastLoginDate(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
		user.setLastLoginIP(HttpUtils.getIpAddr(request));

		userSrv.update(user);

		List<Menu> list = permissionSrv.permission(WebUtils.getUserId(), SystemConstant.SYS_MENU_TYPE_PDA);
		Set<String> buttons = Sets.newConcurrentHashSet();
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).getFactory() != null && list.get(i).getFactory() == 0) {
				continue;

			} else {
				if (list.get(i).getFactory() == null || !login.getFactory().equals(list.get(i).getFactory().toString())) {
					list.remove(i);// 校验请求的工厂信息
					continue;
				}
			}
			if (list.get(i).getType() == 3) {
				buttons.add(list.get(i).getCode());
				list.remove(i);
			}
		}
		session.setAttribute(SessionConstant.USER_PERMISSION, buttons);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("session", session.getId());
		map.put("menus", list);

		map.put("uid", user.getId());
		map.put("userCode", user.getUserCode());
		map.put("userName", user.getUserName());

		return Response.suc(map);
	}

	@Log(value = "修改密码", code = "PDA_PASSWORD", target = LogType.DB)
	@RequestMapping(value = "modifypassword", method = RequestMethod.POST)
	public Response login(@RequestBody ModifyPassword mp) throws NoSuchAlgorithmException {

		User u = WebUtils.getUser();
		u.setUserPassword(MD5Utils.md5(mp.getNewPassword(), SystemConstant.SYS_MD5_SALT));
		userSrv.update(u);

		return Response.suc();
	}

	@Log(value = "用户退出登录", code = "PDA_PASSWORD", target = LogType.CONSOLE)
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public Response out() {
		if (!session.isNew()) {
			session.invalidate();
		}
		return Response.suc();
	}

	@NoLogin
	@Log(value = "APP用户登录", code = "APP_LOGIN", target = LogType.DB)
	@RequestMapping("/applogin")
	// 默认支持POST，GET
	public void applogin(@RequestBody Login login, HttpServletResponse res) throws Exception {
		HttpResult result = new HttpResult();
		LanguageProvider.setLanguage(login.getLanguage());
		User user = userSrv.unique("userCode", login.getCode());

		String md5_password = MD5Utils.md5(login.getPassword(), SystemConstant.SYS_MD5_SALT);

		if (user == null || !user.getUserPassword().equals(md5_password)) {
			result.setCode("1001");
			result.setMsg("请输入正确的账户或密码");
			result.setResults("");
			res.getWriter().write(JSON.toJSONString(result));
			res.getWriter().close();
			return;

		}

		if (user.getAccountState().equals("锁定")) {
			result.setCode("1001");
			result.setMsg("你的账户已被锁定");
			result.setResults("");
			res.getWriter().write(JSON.toJSONString(result));
			res.getWriter().close();
			return;
		}

		// 登陆成功后

		session.setAttribute(SessionConstant.USER_ID, user.getId());
		session.setAttribute(SessionConstant.USER_NAME, user.getUserName());
		session.setAttribute(SessionConstant.USER, user);
		session.setAttribute(SessionConstant.FACTORY, login.getFactory());

		user.setLastLoginDate(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
		user.setLastLoginIP(HttpUtils.getIpAddr(request));

		userSrv.update(user);

		List<Menu> list = permissionSrv.permission(WebUtils.getUserId(), SystemConstant.SYS_MENU_TYPE_PDA);
		Set<String> buttons = Sets.newConcurrentHashSet();
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).getFactory() != null && list.get(i).getFactory() == 0) {
				continue;

			} else {
				if (list.get(i).getFactory() == null || !login.getFactory().equals(list.get(i).getFactory().toString())) {
					list.remove(i);// 校验请求的工厂信息
					continue;
				}
			}
			if (list.get(i).getType() == 3) {
				buttons.add(list.get(i).getCode());
				list.remove(i);
			}
		}
		session.setAttribute(SessionConstant.USER_PERMISSION, buttons);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("session", session.getId());
		map.put("uid", user.getId());
		map.put("userCode", user.getUserCode());
		map.put("userName", user.getUserName());
		// for (int i = 0; i < list.size(); i++) {
		// if (list.get(i).getName().length() < 6 &&
		// !list.get(i).getName().equals("下线查询")
		// && !list.get(i).getName().equals("外观检测")) {
		// list.remove(i);
		// i--;
		// }
		// }
		result.setCode("1000");
		result.setMsg(JSON.toJSONString(list));
		result.setResults(JSON.toJSONString(map));
		res.getWriter().write(JSON.toJSONString(result));
		res.getWriter().close();
		return;
	}
}
