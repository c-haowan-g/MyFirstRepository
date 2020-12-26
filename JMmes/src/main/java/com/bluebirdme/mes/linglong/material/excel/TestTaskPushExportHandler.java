/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.material.service.TestTaskPushServiceImpl;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class TestTaskPushExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	TestTaskPushServiceImpl service = (TestTaskPushServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"TestTaskPushServiceImpl"首字母改为小写
   				.firstCharToLowerCase("TestTaskPushServiceImpl"));
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
    
       /* // 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
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
        
        // 修改人
        regFormatter("changed_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //changed_by_s
                return null;
            }
        });
        
        // 修改时间
        regFormatter("changed_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //changed_time_t
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
        
        // 创建时间
        regFormatter("created_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_time_t
                return null;
            }
        });
        
        // 任务反馈标记：0-待处理、1-已处理、2-已拒绝
        regFormatter("data_check_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //data_check_flag_s
                return null;
            }
        });
        
        // 备用字段1：DQW检测项名称-气味等级是否合格：0-无DQW检测项，1-合格，2-不合格
        regFormatter("dummy1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy1_s
                return null;
            }
        });
        
        // 备用字段2：物料组名称
        regFormatter("dummy2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy2_s
                return null;
            }
        });
        
        // 备用字段3
        regFormatter("dummy3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy3_s
                return null;
            }
        });
        
        // 备用字段4
        regFormatter("dummy4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy4_s
                return null;
            }
        });
        
        // 备用字段5
        regFormatter("dummy5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy5_s
                return null;
            }
        });
        
        // 最终检测结果
        regFormatter("finalresult_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //finalresult_s
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
        
        // MES业务主键
        regFormatter("mesbusinesscode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mesbusinesscode_s
                return null;
            }
        });
        
        // 是否超期:0-正常状态 1-超期
        regFormatter("outofdateflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outofdateflag_s
                return null;
            }
        });
        
        // 条码：长度15位  条码前九位（物料名）、后六位（厂家）
        regFormatter("producername_custom_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //producername_custom_s
                return null;
            }
        });
        
        // 条码：长度21位  条码前九位（物料名）、后六位（厂家）
        regFormatter("producername_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //producername_s
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
        
        // 拒绝原因
        regFormatter("refusereason_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //refusereason_s
                return null;
            }
        });
        
        // 拒绝-接收时间
        regFormatter("refuse_receive_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //refuse_receive_time_t
                return null;
            }
        });
        
        // 结果-接收时间
        regFormatter("result_receive_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //result_receive_time_t
                return null;
            }
        });
        
        // 检测结果：JSON格式
        regFormatter("result_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //result_s
                return null;
            }
        });
        
        // 样品批次：进厂批次
        regFormatter("samplebatch_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //samplebatch_s
                return null;
            }
        });
        
        // 样品名称
        regFormatter("samplename_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //samplename_s
                return null;
            }
        });
        
        // SAP号
        regFormatter("sapcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sapcode_s
                return null;
            }
        });
        
        // 下发人
        regFormatter("send_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_by_s
                return null;
            }
        });
        
        // 下发人姓名
        regFormatter("send_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_name_s
                return null;
            }
        });
        
        // 下发标识：0-未下发、1-已下发、2-下发失败
        regFormatter("send_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_state_s
                return null;
            }
        });
        
        // 下发时间
        regFormatter("send_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_time_t
                return null;
            }
        });
        
        // MES状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库）
        regFormatter("state_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //state_code_s
                return null;
            }
        });
        
        // 进货数量
        regFormatter("stocknum_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //stocknum_s
                return null;
            }
        });
        
        // 供应商
        regFormatter("suppliername_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //suppliername_s
                return null;
            }
        });
        
        // 同步时间
        regFormatter("sync_create_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_create_time_t
                return null;
            }
        });
        
        // 数据同步处理：A-新增、U-修改、D-删除
        regFormatter("sync_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_flag_s
                return null;
            }
        });
        
        // 数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_s
                return null;
            }
        });
        
        // 数据同步处理反馈
        regFormatter("sync_hand_msg_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_s
                return null;
            }
        });
        
        // 处理时间
        regFormatter("sync_hand_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_t
                return null;
            }
        });
        
        // 工厂（1全钢 2半钢）
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 专业组ID 114 技术中心化学组（招远） 115 技术中心物理组（招远） 123 实验中心化学检测室（招远） 124 实验中心半成品实验室（招远） 1101 实验中心化学实验室（柳州） 1102 实验中心半成品实验室（柳州）
        regFormatter("tdmgroupid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tdmgroupid_s
                return null;
            }
        });
        
        // 厂家批次
        regFormatter("venderbatch_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //venderbatch_s
                return null;
            }
        });*/
        
    }

}
