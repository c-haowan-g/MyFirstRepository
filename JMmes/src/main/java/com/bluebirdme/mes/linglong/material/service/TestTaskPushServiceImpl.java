/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.mes.linglong.common.service.CoreDictionaryServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.material.entity.TestTaskPush;
import com.bluebirdme.mes.linglong.material.entity.TestTaskDenial;
import com.bluebirdme.mes.linglong.material.entity.TestTaskDetial;





import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import java.util.Date;
/**
 * TDM检测任务执行表[MES发WMS]
 * @author 李昂
 * @Date 2020-08-11 08:21:36
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TestTaskPushServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	/**
	 *ServiceImpl可以继承RockWellBaseServiceImpl,RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候，返回值为List<Map<String,Object>>类型。
	 RockWellBaseServiceImpl使用datagrid查询返回的是List<T>类型，这个类型是根据Controller里面，调用datagrid
	 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return TestTaskPush.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
        		//将MAP转换为实体
        		TestTaskPush testtaskpush=(TestTaskPush) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), TestTaskPush.class);
        		//testtaskpush.setCreated_time_t(new Date()); 
        		list.add(testtaskpush);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		TestTaskPush testtaskpush =(TestTaskPush) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), TestTaskPush.class);
        		//testtaskpush.setCreated_time_t(new Date()); 
        		list.add(testtaskpush);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		TestTaskPush testtaskpush=(TestTaskPush) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), TestTaskPush.class);
        		//testtaskpush.setCreated_time_t(new Date()); 
        		update(testtaskpush);
        	}
        }
    
    }
    public String exportService(String mesbusinesscode_s, HttpServletRequest request, HttpServletResponse response, List<TestTaskPush> listPush, List<TestTaskDenial> listDenial,  List<TestTaskDetial> listDetail) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("TDM检测任务推送");
        HSSFSheet sheet1 = wb.createSheet("TDM检测任务拒绝信息");
        HSSFSheet sheet2 = wb.createSheet("TDM检测任务明细");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download");

        // 设置下载文件的文件名称
        String fileName = "TDM检测任务查询" + new SimpleDateFormat("YYYY-MM-dd").format(new Date()) + ".xls";
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HSSFCellStyle cellStyle = wb.createCellStyle();
        HSSFCellStyle cellStyleContent = wb.createCellStyle();

        //设置居中
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框//下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //左边框
        cellStyle.setBorderLeft(BorderStyle.DASH_DOT_DOT);
        //上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        //右边框
        cellStyle.setBorderRight(BorderStyle.THIN);

        //设置居中//水平居中
        cellStyleContent.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        cellStyleContent.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框//下边框
        cellStyleContent.setBorderBottom(BorderStyle.THIN);
        //左边框
        cellStyleContent.setBorderLeft(BorderStyle.DASH_DOT_DOT);
        //上边框
        cellStyleContent.setBorderTop(BorderStyle.THIN);
        //右边框
        cellStyleContent.setBorderRight(BorderStyle.THIN);

        //改变字体样式，步骤
        HSSFFont hssfFont = wb.createFont();
        //字体粗体显示
        hssfFont.setBold(true);
        hssfFont.setFontName("宋体");
        // 字体大小
        hssfFont.setFontHeightInPoints((short) 13);
        //改变字体样式，步骤
        HSSFFont hssfFontContent = wb.createFont();
        hssfFont.setFontName("宋体");
        // 字体大小
        hssfFontContent.setFontHeightInPoints((short) 9);

        String[] arr = {"MES业务主键", "Mes状态编码", "反馈标记", "拒绝原因", "检测结果", "条码", "物料编码", "样品名称","样品批次","供应商","进货数量","厂家批次","是否超期","拒绝-接收时间","结果-接收时间","专业组","工厂","结构编码"};
        String[] arr1 = {"条码","样品批次","拒绝原因","接收时间"};
        String[] arr2 = {"条码","样品批次","测试结果","检测项目","检测参数","检测方法","条件单位","条件要求值","条件实际值","执行标准","判断范围","分项结论","接收时间"};
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;
        //创建第一行
        HSSFRow row1 = sheet1.createRow(0);
        HSSFCell cell1;
        //创建第一行
        HSSFRow row2 = sheet2.createRow(0);
        HSSFCell cell2;
        for (int j = 0; j < arr.length; j++) {
            //设置字体
            cellStyle.setFont(hssfFont);
            cell = row.createCell((short) j);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(arr[j]);
            //自动设宽
            sheet.autoSizeColumn(j);
        }
        for (int j = 0; j < arr1.length; j++) {
            // 字体大小
            cellStyle.setFont(hssfFont);//设置字体
            cell1 = row1.createCell((short) j);
            cell1.setCellStyle(cellStyle);
            cell1.setCellValue(arr1[j]);
            sheet1.autoSizeColumn(j);//自动设宽
        }
        for (int j = 0; j < arr2.length; j++) {
            // 字体大小
            cellStyle.setFont(hssfFont);//设置字体
            cell2 = row2.createCell((short) j);
            cell2.setCellStyle(cellStyle);
            cell2.setCellValue(arr2[j]);
            sheet2.autoSizeColumn(j);//自动设宽
        }

        //设置并添加内容
        for (int j = 0; j < listPush.size(); j++) {
            TestTaskPush ato =  listPush.get(j);
            List<Map<String, Object>> a = a(ato.getMesbusinesscode_s());
      /*      List<Map<String, Object>> listSumQty = SumQty(a.get(0).get("ATR_KEY").toString());
            List<Map<String, Object>> listRealityQty = RealityQty(ato.getSnno_s());*/
            row = sheet.createRow(j + 1);
            for (int i = 0; i < arr.length; i++) {
                cellStyleContent.setFont(hssfFontContent);//设置字体
                cell = row.createCell((short) i);
                cell.setCellStyle(cellStyleContent);
                switch (i) {
                    case 0:
                        String mesbusinesscode_s1 = null == ato.getMesbusinesscode_s() ? "" : ato.getMesbusinesscode_s();
                        cell.setCellValue(mesbusinesscode_s1);
                        break;
                    case 1:
                        String state_code_s = null == ato.getState_code_s() ? "" : ato.getState_code_s();
                        ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
                        state_code_s = exportServiceImpl.getDictName(state_code_s);
                        cell.setCellValue(state_code_s);
                        break;
                    case 2:
                        String data_check_flag_s = null == ato.getData_check_flag_s() ? "" : ato.getData_check_flag_s();
                        switch(data_check_flag_s){
                            case "0":
                                data_check_flag_s="待处理";
                                break;
                            case "1":
                                data_check_flag_s="已处理";
                                break;
                            case "2":
                                data_check_flag_s="已拒绝";
                                break;
                        }

                        cell.setCellValue(data_check_flag_s);
                        break;
                    case 3:
                        String refusereason_s = null == ato.getRefusereason_s() ? "" : ato.getRefusereason_s();
                        cell.setCellValue(refusereason_s);
                        break;
                    case 4:
                        String result_s = null == ato.getResult_s() ? "" : ato.getResult_s();
                        cell.setCellValue(result_s);
                        break;
                    case 5:
                        String producername_custom_s = null == ato.getProducername_custom_s() ? "" : ato.getProducername_custom_s();
                        cell.setCellValue(producername_custom_s);
                        break;
                    case 6:
                        String sapcode_s = null == ato.getSapcode_s() ? "" : ato.getSapcode_s();
                        cell.setCellValue(sapcode_s);
                        break;
                    case 7:
                        String samplename_s = null == ato.getSamplename_s() ? "" : ato.getSamplename_s();
                        cell.setCellValue(samplename_s);
                        break;
                    case 8:
                        String samplebatch_s = null == ato.getSamplebatch_s() ? "" : ato.getSamplebatch_s();
                        cell.setCellValue(samplebatch_s);
                        break;
                    case 9:
                        String suppliername_s = null == ato.getSuppliername_s() ? "" : ato.getSuppliername_s();
                        cell.setCellValue(suppliername_s);
                        break;
                    case 10:
                        String stocknum_s = null == ato.getStocknum_s() ? "" : ato.getStocknum_s();
                        cell.setCellValue(stocknum_s);
                        break;
                    case 11:
                        String venderbatch_s = null == ato.getVenderbatch_s() ? "" : ato.getVenderbatch_s();
                        cell.setCellValue(venderbatch_s);
                        break;
                    case 12:
                        String outofdateflag_s = null == ato.getOutofdateflag_s() ? "" : ato.getOutofdateflag_s();
                        switch(outofdateflag_s){
                            case "0":
                                outofdateflag_s="正常状态";
                                break;
                            case "1":
                                outofdateflag_s="超期";
                                break;
                        }
                        cell.setCellValue(outofdateflag_s);
                        break;
                    case 13:
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
                        String refuse_receive_time_t = null == ato.getRefuse_receive_time_t() ? "" : df.format(ato.getRefuse_receive_time_t());
                        cell.setCellValue(refuse_receive_time_t);
                        break;
                    case 14:
                        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
                        String result_receive_time_t = null == ato.getResult_receive_time_t() ? "" : df1.format(ato.getResult_receive_time_t());
                        cell.setCellValue(result_receive_time_t);
                        break;
                    case 15:
                        String tdmgroupid_s = null == ato.getTdmgroupid_s() ? "" : ato.getTdmgroupid_s();
                        CoreDictionaryServiceImpl dictSrv = (CoreDictionaryServiceImpl) SpringContext.getBean("coreDictionaryServiceImpl");
                        Map<String,Object> map = dictSrv.keyValuePair("-337");
                        tdmgroupid_s = (String) map.get(tdmgroupid_s);
                        cell.setCellValue(tdmgroupid_s);
                        break;
                    
                    case 17:
                        String agenc_no_s = null == ato.getAgenc_no_s() ? "" : ato.getAgenc_no_s();
                        switch(agenc_no_s){
                            case "8000":
                                agenc_no_s="招远";
                                break;
                            case "8002":
                                agenc_no_s="德州";
                                break;
                            case "8003":
                                agenc_no_s="柳州";
                                break;
                            case "8004":
                                agenc_no_s="泰国";
                                break;
                        }
                        cell.setCellValue(agenc_no_s);
                        break;
                }
                sheet.autoSizeColumn(i);//自动设宽
            }
        }

        for (int j = 0; j < listDenial.size(); j++) {
            TestTaskDenial ato =  listDenial.get(j);
            List<Map<String, Object>> denial = denial(ato.getMesbusinesscode_s());
//            List<Map<String, Object>> listRealityQty = RealityQty2(ato.getSnno_s(), ato.getMaterialcode_s());
            row = sheet1.createRow(j + 1);
            for (int i = 0; i < arr1.length; i++) {
                cellStyleContent.setFont(hssfFontContent);//设置字体
                cell = row.createCell((short) i);
                cell.setCellStyle(cellStyleContent);
                switch (i) {
                    case 0:
                        String venderbatch_short_s = null == ato.getVenderbatch_short_s() ? "" : ato.getVenderbatch_short_s();
                        cell.setCellValue(venderbatch_short_s);
                        break;
                    case 1:
                        String samplebatch_s = null == ato.getSamplebatch_s() ? "" : ato.getSamplebatch_s();
                        cell.setCellValue(samplebatch_s);
                        break;
                    case 2:
                        String refusereason_s = null == ato.getRefusereason_s() ? "" : ato.getRefusereason_s();
                        cell.setCellValue(refusereason_s);
                        break;
                    case 3:
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
                        String receive_time_t = null ==  ato.getReceive_time_t() ? "": df.format(ato.getReceive_time_t());
                        cell.setCellValue(receive_time_t);
                        break;
                }
                sheet1.autoSizeColumn(i);//自动设宽
            }
        }

       /* for (int j = 0; j < listResult.size(); j++) {
            TestTaskResult ato =  listResult.get(j);
            List<Map<String, Object>> detailResult = detailResult(ato.getMesbusinesscode_s());
            row = sheet2.createRow(j + 1);
            for (int i = 0; i < arr2.length; i++) {
                cellStyleContent.setFont(hssfFontContent);//设置字体
                cell = row.createCell((short) i);
                cell.setCellStyle(cellStyleContent);
                switch (i) {
                    case 1:
                        String SAMPLEBATCH_S = null == ato.getSamplebatch_s() ? "" : ato.getSamplebatch_s();
                        cell.setCellValue(SAMPLEBATCH_S);
                        break;
                    case 12:
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
                        String RECEIVE_TIME_T = null == ato.getReceive_time_t() ? "" : df.format(ato.getReceive_time_t());
                        cell.setCellValue(RECEIVE_TIME_T);
                        break;
                }
                sheet2.autoSizeColumn(i);//自动设宽
            }
        }
*/
        for (int j = 0; j < listDetail.size(); j++) {
            TestTaskDetial atod =  listDetail.get(j);
            List<Map<String, Object>> detailDetail = detailDetail(atod.getMesbusinesscode_s());
            row = sheet2.createRow(j + 1);
            for (int i = 0; i < arr2.length; i++) {
                cellStyleContent.setFont(hssfFontContent);//设置字体
                cell = row.createCell((short) i);
                cell.setCellStyle(cellStyleContent);
                switch (i) {
                    case 0:
                        String VENDERBATCH_S = null == atod.getVenderbatch_s() ? "" : atod.getVenderbatch_s();
                        cell.setCellValue(VENDERBATCH_S);
                        break;
                    case 2:
                        String TEST_RESULT_S = null == atod.getTest_result_s() ? "" : atod.getTest_result_s();
                        cell.setCellValue(TEST_RESULT_S);
                        break;
                    case 3:
                        String TEST_ITEMS_S = null == atod.getTest_items_s() ? "" : atod.getTest_items_s();
                        cell.setCellValue(TEST_ITEMS_S);
                        break;
                    case 4:
                        String TEST_PARAS_S = null == atod.getTest_paras_s() ? "" : atod.getTest_paras_s();
                        cell.setCellValue(TEST_PARAS_S);
                        break;
                    case 5:
                        String TEST_METHOD_S = null == atod.getTest_method_s() ? "" : atod.getTest_method_s();
                        cell.setCellValue(TEST_METHOD_S);
                        break;
                    case 6:
                        String EXECUTIVE_UNIT_S = null == atod.getExecutive_unit_s() ? "" : atod.getExecutive_unit_s();
                        cell.setCellValue(EXECUTIVE_UNIT_S);
                        break;
                    case 7:
                        String EXECUTIVE_REQVALUE_S = null == atod.getExecutive_reqvalue_s() ? "" : atod.getExecutive_reqvalue_s();
                        cell.setCellValue(EXECUTIVE_REQVALUE_S);
                        break;
                    case 8:
                        String EXECUTIVE_ACTUALVALUE_S = null == atod.getExecutive_actualvalue_s() ? "" : atod.getExecutive_actualvalue_s();
                        cell.setCellValue(EXECUTIVE_ACTUALVALUE_S);
                        break;
                    case 9:
                        String EXECUTIVE_STANDARD_S = null == atod.getExecutive_standard_s() ? "" : atod.getExecutive_standard_s();
                        cell.setCellValue(EXECUTIVE_STANDARD_S);
                        break;
                    case 10:
                        String DECISIONSCOPE_S = null == atod.getDecisionscope_s() ? "" : atod.getDecisionscope_s();
                        cell.setCellValue(DECISIONSCOPE_S);
                        break;
                    case 11:
                        String SUB_CONCLUSION_S = null == atod.getSub_conclusion_s() ? "" : atod.getSub_conclusion_s();
                        cell.setCellValue(SUB_CONCLUSION_S);
                        break;
                }
                sheet2.autoSizeColumn(i);//自动设宽
            }
        }

        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            OutputStream out = response.getOutputStream();
            wb.write(out);
            out.close();
            System.out.println("输出完成");
            return "输出完成";
        } catch (Exception e) {
            System.out.println("文件输出失败!");
            e.printStackTrace();
            return "文件输出失败!";
        }
    }
    public List<Map<String, Object>> a(String mesbusinesscode_s){
        SQLQuery query = createSQLQuery(getSQL("a"));
        query.setParameter("mesbusinesscode_s", mesbusinesscode_s);
        return query.list();
    }
    public List<Map<String, Object>> denial(String mesbusinesscode_s){
        SQLQuery query = createSQLQuery(getSQL("denial"));
        query.setParameter("mesbusinesscode_s", mesbusinesscode_s);
        return query.list();
    }
    public List<Map<String, Object>> detailDetail(String mesbusinesscode_s){
        SQLQuery query = createSQLQuery(getSQL("detailDetail"));
        query.setParameter("mesbusinesscode_s", mesbusinesscode_s);
        return query.list();
    }

}
