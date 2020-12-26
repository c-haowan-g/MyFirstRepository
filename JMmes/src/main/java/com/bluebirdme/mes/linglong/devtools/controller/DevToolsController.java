/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.devtools.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.FreemarkerUtils;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.ext.HttpUtils;
import org.xdemo.app.xutils.ext.ZipUtils;
import org.xdemo.app.xutils.j2se.DateUtils;
import org.xdemo.app.xutils.j2se.FileUtils;
import org.xdemo.app.xutils.j2se.PathUtils;
import org.xdemo.app.xutils.j2se.PropertiesUtils;

import com.bluebirdme.core.common.entity.I18N;
import com.bluebirdme.core.common.service.I18NServiceImpl;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.base.BaseController;
import com.bluebirdme.core.system.spring.i18n.DatabaseMessageSource;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.devtools.entity.Col;
import com.bluebirdme.mes.linglong.devtools.service.DbServiceImpl;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * @author Goofy
 * @Date 2018年6月27日 下午3:13:20
 */
@NoLogin
@RestController
@RequestMapping("/devtools")
public class DevToolsController extends BaseController {

	@Resource
	DbServiceImpl dbSrv;

	@Resource
	I18NServiceImpl i18nSrv;

	@Resource
	DatabaseMessageSource msgSrc;

	@RequestMapping("db")
	public String getTables(String tblName) throws Exception {
		if (StringUtils.isEmpty(tblName)) {
			return GsonTools.toJson(dbSrv.getTables());
		}
		return GsonTools.toJson(dbSrv.getColumns(tblName));
	}

	@RequestMapping("gen")
	public Response generate(String tblName, String url, String logCode, String logName, String tableName,
			String entityName, String author, String comment, String packageName) throws Exception {

		List<Col> cs = dbSrv.getColumns(tblName);

		List<I18N> list = new ArrayList<I18N>();

		I18N i18n = null;

		for (Col c : cs) {

			if (!i18nSrv.exist("code", entityName.toLowerCase() + ".column." + c.getName().toLowerCase())) {
				i18n = new I18N();

				i18n.setCode(entityName.toLowerCase() + ".column." + c.getName().toLowerCase());

				if (c.getMemo() == null) {
					continue;
				}

				i18n.setEn(c.getMemo());
				i18n.setTh(c.getMemo());
				i18n.setZh(c.getMemo());

				list.add(i18n);
			}

			switch (c.getType().toUpperCase()) {
			case "STRING":
				c.setType("String");
				break;
			case "DATETIME":
				c.setType("Date");
				break;
			case "INTEGER":
				c.setType("Integer");
				break;
			default:
				c.setType("String");
				break;
			}

		}
		if (list.size() != 0) {
			i18nSrv.save(list);
			msgSrc.init();
		}

		String ftl_base = "";
		if (tblName.startsWith("AT_")) {
			ftl_base = PathUtils.classPath() + "com/bluebirdme/mes/linglong/devtools/controller/tpl/";
		} else {
			ftl_base = PathUtils.classPath() + "com/bluebirdme/mes/linglong/devtools/controller/UDA/";
		}
		String uuid = UUID.randomUUID().toString();

		String target_base = PathUtils.classPath() + "temp/gen/" + uuid + "/";

		String zip = PathUtils.classPath() + "temp" + File.separator + uuid + ".zip";

		new File(target_base).mkdirs();

		ftl_base = PathUtils.toOsPath(ftl_base);
		target_base = PathUtils.toOsPath(target_base);
		zip = PathUtils.toOsPath(zip);

		if (SystemUtils.IS_OS_WINDOWS) {
			ftl_base = ftl_base.substring(1);
			target_base = target_base.substring(1);
			zip = zip.substring(1);
		}

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("url", url);
		data.put("logCode", logCode);
		data.put("logName", logName);
		data.put("tableName", tableName);
		data.put("entityName", entityName);
		data.put("author", author);
		data.put("comment", comment);
		data.put("packageName", packageName);
		data.put("columns", cs);
		data.put("time", DateUtils.now("yyyy-MM-dd HH:mm:ss"));

		gen(entityName, target_base, ftl_base, data);

		ZipUtils.zipDir(target_base, zip, entityName + "\t" + author + "\t" + comment);

		return Response.suc(uuid);
	}

	@RequestMapping("down")
	public void download(String uuid, String entityName) {
		String zip = PathUtils.classPath() + "temp" + File.separator + uuid + ".zip";
		HttpUtils.download(response, new File(zip), entityName + ".zip");
		new File(zip).delete();
		FileUtils.deleteByDir(new File(PathUtils.classPath() + "temp/gen/" + uuid + "/"));
	}

	public void gen(String entityName, String target_base, String ftl_base, Object data)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
			TemplateException {
		Map<String, Object> map = (Map<String, Object>) data;
		String tableName = map.get("tableName").toString();
		if (tableName.startsWith("AT_")) {
			FreemarkerUtils.generateToFile(ftl_base, "entity.ftl", target_base + entityName + ".java", data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "controller.ftl", target_base + entityName + "Controller.java",
					data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "service.ftl", target_base + entityName + "ServiceImpl.java",
					data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "service.xml.ftl", target_base + entityName + "ServiceImpl.xml",
					data, "UTF-8");
			// FreemarkerUtils.generateToFile(ftl_base,"message_ch.ftl",target_base+"message_zh.properties",
			// data, "UTF-8");
			// FreemarkerUtils.generateToFile(ftl_base,"message_th.ftl",target_base+"message_th.properties",
			// data, "UTF-8");
			// FreemarkerUtils.generateToFile(ftl_base,"message_en.ftl",target_base+"message_en.properties",
			// data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "jsp.ftl", target_base + entityName.toLowerCase() + ".jsp", data,
					"UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "js.jsp.ftl", target_base + entityName.toLowerCase() + ".js.jsp",
					data, "UTF-8");
			//FreemarkerUtils.generateToFile(ftl_base, "dto.ftl", target_base + entityName + "DTO.java", data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "excel.export.ftl", target_base + entityName
					+ "ExportHandler.java", data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "excel.import.ftl", target_base + entityName
					+ "ImportHandler.java", data, "UTF-8");
		} else {
			FreemarkerUtils.generateToFile(ftl_base, "entityUDA.ftl", target_base + entityName + "UDA.java", data,
					"UTF-8");
//			FreemarkerUtils.generateToFile(ftl_base, "udaDto.ftl", target_base + entityName + "UdaDTO.java", data,
//					"UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "controllerUDA.ftl", target_base + entityName + "Controller.java",
					data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "serviceUDA.ftl", target_base + entityName + "ServiceImpl.java",
					data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "service.xml.ftl", target_base + entityName + "ServiceImpl.xml",
					data, "UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "jsp.ftl", target_base + entityName.toLowerCase() + ".jsp", data,
					"UTF-8");
			FreemarkerUtils.generateToFile(ftl_base, "js.jsp.ftl", target_base + entityName.toLowerCase() + ".js.jsp",
					data, "UTF-8");
		}

	}

	@NoLogin
	@RequestMapping("parse")
	public Response parse() throws FileNotFoundException, IOException {

		List<File> list = FileUtils.getFiles("D:\\x\\");

		List<I18N> msg = new ArrayList<I18N>();

		Properties p;
		Set<Object> keys;

		I18N i = null;

		for (File file : list) {

			if (file.getName().startsWith("message_zh")) {
				p = PropertiesUtils.load(file.getAbsolutePath());

				keys = p.keySet();

				for (Object k : keys) {
					i = new I18N();
					i.setCode(k.toString());
					System.out.println(k.toString() + "\t" + p.get(k).toString());
					i.setZh(p.get(k).toString());
					i.setTh(p.get(k).toString());
					i.setEn(p.get(k).toString());
					// if(!i18nSrv.exist("code", i.getCode())){
					msg.add(i);
					// }
				}

			}

		}
		System.out.println(msg.size());

		// for(int j=0;j<200;j++){
		// i18nSrv.save(msg.subList(j*100, (j+1)*100));
		// }

		i18nSrv.save(msg);

		return Response.suc();
	}

}
