package com.bluebirdme.mes.linglong.core.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import bsh.This;


public class XmlfilterUtil {
	/**
	 * 周清玉 创建XML文件
	 * @param url 生成路径
	 * @param parameterName 使用查询词
	 * @param value 值
	 * @param describe 描述
	 * @throws IOException
	 */
	public static void write(String url,String parameterName,String value,String describe) throws IOException{
		//创建文档Document
		Document document = DocumentHelper.createDocument();
		//创建根节点。同事添加document对象中
		Element conListElem = document.addElement("parameter-list");
		
		//创建子节点，同事添加到根节点上
		Element contactElem =conListElem.addElement("parameter");
		//为子节点添加属性
		contactElem.addAttribute("parameterName", parameterName);
		//创建下一级节点，添加到父节点
		Element valElement  = contactElem.addElement("value");
		valElement.addText(value);
		Element describeElement  = contactElem.addElement("describe");
		describeElement.addText(value);
		//Document
		FileWriter fWriter = new FileWriter(url+"/parameter.xml");
		//创建输出格式与编码
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setEncoding("utf-8");
		 // 设置换行
		format.setNewlines(true);
        // 生成缩进
		format.setIndent(true);
        // 使用4个空格进行缩进, 可以兼容文本编辑器
		format.setIndent("    ");
		XMLWriter writer = new XMLWriter(fWriter,format);
		writer.write(document);
		writer.close();
	}
	/**
	 * 周清玉 添加XML文件节点
	 * @param url
	 * @param parameterName
	 * @param value
	 * @param describe
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void add(String url,String parameterName,String value,String describe) throws IOException, DocumentException{
		//读取源文件
		File xmlFile = new File(url+"/parameter.xml");
		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlFile);
		//增加标签
		Element newElement = document.getRootElement().addElement("parameter");
		newElement.addAttribute("parameterName", parameterName);
		
		newElement.addElement("value");
		newElement.element("value").setText(value);
		newElement.addElement("describe");
		newElement.element("describe").setText(describe);
		
		OutputStream outputStream = new FileOutputStream(url+"/parameter.xml");
		OutputFormat format = OutputFormat.createCompactFormat();
		
		format.setEncoding("utf-8");
		// 设置换行
		format.setNewlines(true);
		// 生成缩进
		format.setIndent(true);
		// 使用4个空格进行缩进, 可以兼容文本编辑器
		format.setIndent("    ");
		XMLWriter writer = new XMLWriter(outputStream,format);
		writer.write(document);
		writer.close();
	}
	
	/**
	 * 周清玉
     * 根据路径获取xml
     * @param xmlPath  xml路径
     * @return
     * @throws DocumentException
     */
    public static String getXml(String xmlPath) throws DocumentException {
    	SAXReader reader=new SAXReader();
        Document document =reader.read(xmlPath);
        return document.asXML();
    }
    
    /**
     * 周清玉
     * xml转换为Map类list
     * @param code 节点值
     * @return
     * @throws DocumentException
     */
    public static  List<Map<String, String>> resolveXmlToMapList(String xml ,String code) throws DocumentException {
        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
        List<Map<String, String>> ListMap = new ArrayList<Map<String, String>>();
        Document document = DocumentHelper.parseText(xml);
        List<Element> condition = document.getRootElement().elements("parameter");
        
        for(Element element : condition){
            Map resultMap = new HashMap();
            List<Attribute> attributes = element.attributes();
            if(attributes!=null&&attributes.size()>0){
                for(Attribute attribute : attributes){
                    resultMap.put(attribute.getName(), attribute.getText().replace(" ", ""));
                }
            }
            List<Element> elements = element.elements();
            if(elements!=null&&elements.size()>0){
                for(Element $element : elements){
                    resultMap.put($element.getName(), $element.getText().replace(" ", ""));
                }
            }
            resultList.add(resultMap);
        }
        
        for (Map<String, String> map : resultList) {
			if(map.get("parameterName").equals(code)){
				ListMap.add(map);
			}
		}
        return ListMap;
    }
}
