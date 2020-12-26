/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.export;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.mix.service.MixMonthlyReportServiceImpl;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author 陈国强
 * @Date 2019年8月29日 下午2:30:34
 */
public class MixMonthlyReportExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MixMonthlyReportServiceImpl service = (MixMonthlyReportServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixMonthlyReportServiceImpl"首字母改为小写
   				.firstCharToLowerCase("mixMonthlyReportServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
        /*// 机构编号： 柳州 8003
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }
        });
        
        // 归档标记
        regFormatter("arch_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //arch_flag_s
                return null;
            }
        });
        
        // 创建人
        regFormatter("created_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_by_s
                return null;
            }
        });
        
        // 创建人姓名
        regFormatter("created_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_name_s
                return null;
            }
        });
        
        // 创建时间
        regFormatter("created_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_time_t
                return null;
            }
        });
        
        // 8日车数
        regFormatter("eightday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //eightday_train_i
                return null;
            }
        });
        
        // 8日重量
        regFormatter("eightday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //eightday_weight_d
                return null;
            }
        });
        
        // 18日车数
        regFormatter("eighteenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //eighteenday_train_i
                return null;
            }
        });
        
        // 18日重量
        regFormatter("eighteenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //eighteenday_weight_d
                return null;
            }
        });
        
        // 11日车数
        regFormatter("elevenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //elevenday_train_i
                return null;
            }
        });
        
        // 11日重量
        regFormatter("elevenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //elevenday_weight_d
                return null;
            }
        });
        
        // 机台编码
        regFormatter("equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equip_code_s
                return null;
            }
        });
        
        // 机台名称
        regFormatter("equip_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equip_name_s
                return null;
            }
        });
        
        // 15日车数
        regFormatter("fifteenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fifteenday_train_i
                return null;
            }
        });
        
        // 15日重量
        regFormatter("fifteenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fifteenday_weight_d
                return null;
            }
        });
        
        // 5日车数
        regFormatter("fiveday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fiveday_train_i
                return null;
            }
        });
        
        // 5日重量
        regFormatter("fiveday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fiveday_weight_d
                return null;
            }
        });
        
        // 4日车数
        regFormatter("fourday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fourday_train_i
                return null;
            }
        });
        
        // 4日重量
        regFormatter("fourday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fourday_weight_d
                return null;
            }
        });
        
        // 14日车数
        regFormatter("fourteenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fourteenday_train_i
                return null;
            }
        });
        
        // 14日重量
        regFormatter("fourteenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //fourteenday_weight_d
                return null;
            }
        });
        
        // 主键ID
        regFormatter("id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //id_s
                return null;
            }
        });
        
        // 主机手
        regFormatter("master_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //master_by_s
                return null;
            }
        });
        
        // 主机手姓名
        regFormatter("master_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //master_name_s
                return null;
            }
        });
        
        // 物料编号
        regFormatter("materialcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialcode_s
                return null;
            }
        });
        
        // 物料组
        regFormatter("materialgroup_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialgroup_s
                return null;
            }
        });
        
        // 物料名称
        regFormatter("materialname_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialname_s
                return null;
            }
        });
        
        // 物料规格
        regFormatter("materialspec_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialspec_s
                return null;
            }
        });
        
        // 月份 年+月->201808
        regFormatter("month_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //month_s
                return null;
            }
        });
        
        // 9日车数
        regFormatter("nineday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //nineday_train_i
                return null;
            }
        });
        
        // 9日重量
        regFormatter("nineday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //nineday_weight_d
                return null;
            }
        });
        
        // 19日车数
        regFormatter("ninteenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //ninteenday_train_i
                return null;
            }
        });
        
        // 19日重量
        regFormatter("ninteenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //ninteenday_weight_d
                return null;
            }
        });
        
        // 1日车数
        regFormatter("oneday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //oneday_train_i
                return null;
            }
        });
        
        // 1日重量
        regFormatter("oneday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //oneday_weight_d
                return null;
            }
        });
        
        // 配方编号
        regFormatter("recipe_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_code_s
                return null;
            }
        });
        
        // 配方名称
        regFormatter("recipe_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_name_s
                return null;
            }
        });
        
        // 记录标志，A可用，D删除
        regFormatter("record_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //record_flag_s
                return null;
            }
        });
        
        // 7日车数
        regFormatter("sevenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sevenday_train_i
                return null;
            }
        });
        
        // 7日重量
        regFormatter("sevenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sevenday_weight_d
                return null;
            }
        });
        
        // 17日车数
        regFormatter("seventeenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //seventeenday_train_i
                return null;
            }
        });
        
        // 17日重量
        regFormatter("seventeenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //seventeenday_weight_d
                return null;
            }
        });
        
        // 6日车数
        regFormatter("sixday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sixday_train_i
                return null;
            }
        });
        
        // 6日重量
        regFormatter("sixday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sixday_weight_d
                return null;
            }
        });
        
        // 16日车数
        regFormatter("sixteenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sixteenday_train_i
                return null;
            }
        });
        
        // 16日重量
        regFormatter("sixteenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sixteenday_weight_d
                return null;
            }
        });
        
        // 月产量报表类型：1-密炼、2-半部件、3-成型
        regFormatter("spare1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare1_s
                return null;
            }
        });
        
        // 备用字段2
        regFormatter("spare2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare2_s
                return null;
            }
        });
        
        // 备用字段3
        regFormatter("spare3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare3_s
                return null;
            }
        });
        
        // 备用字段4
        regFormatter("spare4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare4_s
                return null;
            }
        });
        
        // 备用字段5
        regFormatter("spare5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare5_s
                return null;
            }
        });
        
        // 工厂：1-全钢、2-半钢
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 10日车数
        regFormatter("tenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tenday_train_i
                return null;
            }
        });
        
        // 10日重量
        regFormatter("tenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tenday_weight_d
                return null;
            }
        });
        
        // 13日车数
        regFormatter("thirteenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //thirteenday_train_i
                return null;
            }
        });
        
        // 13日重量
        regFormatter("thirteenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //thirteenday_weight_d
                return null;
            }
        });
        
        // 30日车数
        regFormatter("thirtyday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //thirtyday_train_i
                return null;
            }
        });
        
        // 30日重量
        regFormatter("thirtyday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //thirtyday_weight_d
                return null;
            }
        });
        
        // 31日车数
        regFormatter("thirtyoneday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //thirtyoneday_train_i
                return null;
            }
        });
        
        // 31日重量
        regFormatter("thirtyoneday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //thirtyoneday_weight_d
                return null;
            }
        });
        
        // 3日车数
        regFormatter("threeday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //threeday_train_i
                return null;
            }
        });
        
        // 3日重量
        regFormatter("threeday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //threeday_weight_d
                return null;
            }
        });
        
        // 12日车数
        regFormatter("twelvenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twelvenday_train_i
                return null;
            }
        });
        
        // 12日重量
        regFormatter("twelvenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twelvenday_weight_d
                return null;
            }
        });
        
        // 20日车数
        regFormatter("twentyday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyday_train_i
                return null;
            }
        });
        
        // 20日重量
        regFormatter("twentyday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyday_weight_d
                return null;
            }
        });
        
        // 28日车数
        regFormatter("twentyeightday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyeightday_train_i
                return null;
            }
        });
        
        // 28日重量
        regFormatter("twentyeightday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyeightday_weight_d
                return null;
            }
        });
        
        // 25日车数
        regFormatter("twentyfiveday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyfiveday_train_i
                return null;
            }
        });
        
        // 25日重量
        regFormatter("twentyfiveday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyfiveday_weight_d
                return null;
            }
        });
        
        // 24日车数
        regFormatter("twentyfourday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyfourday_train_i
                return null;
            }
        });
        
        // 24日重量
        regFormatter("twentyfourday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyfourday_weight_d
                return null;
            }
        });
        
        // 29日车数
        regFormatter("twentynineday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentynineday_train_i
                return null;
            }
        });
        
        // 29日重量
        regFormatter("twentynineday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentynineday_weight_d
                return null;
            }
        });
        
        // 21日车数
        regFormatter("twentyoneday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyoneday_train_i
                return null;
            }
        });
        
        // 21日重量
        regFormatter("twentyoneday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentyoneday_weight_d
                return null;
            }
        });
        
        // 27日车数
        regFormatter("twentysevenday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentysevenday_train_i
                return null;
            }
        });
        
        // 27日重量
        regFormatter("twentysevenday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentysevenday_weight_d
                return null;
            }
        });
        
        // 26日车数
        regFormatter("twentysixday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentysixday_train_i
                return null;
            }
        });
        
        // 26日重量
        regFormatter("twentysixday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentysixday_weight_d
                return null;
            }
        });
        
        // 23日车数
        regFormatter("twentythreeday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentythreeday_train_i
                return null;
            }
        });
        
        // 23日重量
        regFormatter("twentythreeday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentythreeday_weight_d
                return null;
            }
        });
        
        // 22日车数
        regFormatter("twentytwoday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentytwoday_train_i
                return null;
            }
        });
        
        // 22日重量
        regFormatter("twentytwoday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twentytwoday_weight_d
                return null;
            }
        });
        
        // 2日车数
        regFormatter("twoday_train_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twoday_train_i
                return null;
            }
        });
        
        // 2日重量
        regFormatter("twoday_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //twoday_weight_d
                return null;
            }
        });
    */    
    }

}
