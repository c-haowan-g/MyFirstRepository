/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.Drprodimplement;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.lhqx.ArrayOfanyType;
import com.lhqx.PIReturnObject;
import com.lhqx.WSImplement;
import com.lhqx.WSInterface;

import java.util.Date;
/**
 * 密炼胶料产出车次实绩表
 * @author 栾和源
 * @Date 2020-08-04 13:14:19
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DrprodimplementServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return Drprodimplement.class;
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
        		Drprodimplement drprodimplement=(Drprodimplement) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), Drprodimplement.class);
        		//drprodimplement.setCreated_time_t(new Date()); 
        		list.add(drprodimplement);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		Drprodimplement drprodimplement =(Drprodimplement) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), Drprodimplement.class);
        		//drprodimplement.setCreated_time_t(new Date()); 
        		list.add(drprodimplement);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		Drprodimplement drprodimplement=(Drprodimplement) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), Drprodimplement.class);
        		//drprodimplement.setCreated_time_t(new Date()); 
        		update(drprodimplement);
        	}
        }
    
    }
    /**
     * 密炼胶料产出车次实绩表
     * @author 陈国强
     * @Date 2020-09-16 13:14:19
     */
    public List<Map<String, Object>> ccqx(Map<String, Object> map)
    {
      WSImplement service = new WSImplement();
      WSInterface portType = service.getBasicHttpBindingWSInterface();
      String codes = null;
      String temp = null;
      String energy = null;
      String power = null;
      String rotate = null;
      String press = null;
      String topBoltPosition = null;
      String trainNo = null;
      String planNo = null;
      String equip_code_s = map.get("equip_code_s").toString();
      temp = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.SetTemp";
      energy = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.SetEnergy";
      power = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.SetPower";
      rotate = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.SetRotate";
      press = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.SetPress";
      topBoltPosition = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.SetTopBoltPosition";
      trainNo = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.SerialId";
      planNo = "BGSCADA:BGOPC1112:" + equip_code_s + "." + equip_code_s + ".Technology.PlanNo";

      String start_datetime_s = map.get("start_datetime_s").toString();

      String mixtime_i = map.get("mixtime_i").toString();
      Long mixtime_l = Long.valueOf(Long.parseLong(mixtime_i));
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime localDateTime = LocalDateTime.parse(start_datetime_s, formatter);

      LocalDateTime firstDateTime = localDateTime.minusSeconds(120L);

      start_datetime_s = parseDate(firstDateTime, "yyyy-MM-dd HH:mm:ss");
      start_datetime_s = start_datetime_s.replace("-", "");
      start_datetime_s = start_datetime_s.toString().replace(" ", "");
      start_datetime_s = start_datetime_s.toString().replace(":", "");

      LocalDateTime lastDateTime = localDateTime.plusSeconds(mixtime_l.longValue() + 240L);
      String product_time_t = parseDate(lastDateTime, "yyyy-MM-dd HH:mm:ss");
      product_time_t = product_time_t.replace("-", "");
      product_time_t = product_time_t.toString().replace(" ", "");
      product_time_t = product_time_t.toString().replace(":", "");

      PIReturnObject tempValue = portType.queryRealData(equip_code_s, temp, start_datetime_s, product_time_t);
      PIReturnObject energyValue = portType.queryRealData(equip_code_s, energy, start_datetime_s, product_time_t);
      PIReturnObject powerValue = portType.queryRealData(equip_code_s, power, start_datetime_s, product_time_t);
      PIReturnObject rotateValue = portType.queryRealData(equip_code_s, rotate, start_datetime_s, product_time_t);
      PIReturnObject pressValue = portType.queryRealData(equip_code_s, press, start_datetime_s, product_time_t);
      PIReturnObject topBoltPositionValue = portType.queryRealData(equip_code_s, topBoltPosition, start_datetime_s, product_time_t);
      PIReturnObject trainNoValue = portType.queryRealData(equip_code_s, trainNo, start_datetime_s, product_time_t);
      PIReturnObject planNoValue = portType.queryRealData(equip_code_s, planNo, start_datetime_s, product_time_t);
      ArrayOfanyType arry6 = trainNoValue.getRPidata();
      List bb6 = arry6.getAnyType();
      String sampling = (String)bb6.get(0);
      int it = 0;
      while ((it != bb6.size()) && 
        (sampling.indexOf(String.valueOf(bb6.get(it))) != -1))
      {
        it++;
      }

      ArrayOfanyType arry = tempValue.getRPidata();
      List bb = arry.getAnyType();

      ArrayOfanyType arry1 = energyValue.getRPidata();
      List bb1 = arry1.getAnyType();

      ArrayOfanyType arry2 = powerValue.getRPidata();
      List bb2 = arry2.getAnyType();

      ArrayOfanyType arry3 = rotateValue.getRPidata();
      List bb3 = arry3.getAnyType();

      ArrayOfanyType arry4 = pressValue.getRPidata();
      List bb4 = arry4.getAnyType();

      ArrayOfanyType arry5 = topBoltPositionValue.getRPidata();
      List bb5 = arry5.getAnyType();

      ArrayOfanyType arry7 = planNoValue.getRPidata();
      List bb7 = arry7.getAnyType();

      Integer[] numbers = { Integer.valueOf(bb.size()), Integer.valueOf(bb1.size()), Integer.valueOf(bb2.size()), Integer.valueOf(bb3.size()), Integer.valueOf(bb4.size()), Integer.valueOf(bb5.size()), Integer.valueOf(bb6.size()) };
      int max = ((Integer)Collections.max(Arrays.asList(numbers))).intValue();
      List result = new ArrayList();
      String date = null;
      String firstDate = "";
      for (int i = 0; i < max; i++) {
        Map res = new HashMap();
        try {
          String serial_id_i = map.get("serial_id_i").toString();

          String plan_no_s = map.get("plan_no_s").toString();

          if (i < bb6.size()) {
            Integer serial_id_s = Integer.valueOf(Integer.valueOf(serial_id_i).intValue() - 1);
            String serial_id = bb6.get(i).toString().split(":")[1];
            Integer serialId = Integer.valueOf(serial_id);
            String plan_no = bb7.get(i).toString().split(":")[1];
            plan_no = plan_no.trim();
            if ((!serial_id_s.equals(serialId)) || (!plan_no_s.equals(plan_no)))
            {
              continue;
            }

          }

          if (i < bb.size()) {
            if ("" == firstDate) {
              firstDate = bb.get(i).toString().split(":")[0].substring(8);
            }
            date = bb.get(i).toString().split(":")[0].substring(8);
            StringBuilder firstSb = new StringBuilder(firstDate);
            StringBuilder sb = new StringBuilder(date);
            firstSb.insert(2, ":");
            firstSb.insert(5, ":");
            sb.insert(2, ":");
            sb.insert(5, ":");
            Date firstSbDate = StringToDate(String.valueOf(firstSb));
            Date sbDate = StringToDate(String.valueOf(sb));
            Long surplus = Long.valueOf(sbDate.getTime() - firstSbDate.getTime());
            Double lastplus = Double.valueOf(surplus.longValue() * 0.001D);
            String lastStr = lastplus + "s";
            res.put("date", lastStr);
            double t = Double.parseDouble(bb.get(i).toString().split(":")[1]);
            String tempF = String.format("%.3f", new Object[] { Double.valueOf(t) });
            res.put("temp", tempF);
          }
          if (i < bb1.size()) {
            double e = Double.parseDouble(bb1.get(i).toString().split(":")[1]);
            String energyF = String.format("%.3f", new Object[] { Double.valueOf(e) });
            res.put("energy", energyF);
          }
          if (i < bb2.size()) {
            double p = Double.parseDouble(bb2.get(i).toString().split(":")[1]);
            String powerF = String.format("%.3f", new Object[] { Double.valueOf(p) });
            res.put("power", powerF);
          }
          if (i < bb3.size()) {
            res.put("rotate", bb3.get(i).toString().split(":")[1]);
          }
          if (i < bb4.size()) {
            double pre = Double.parseDouble(bb4.get(i).toString().split(":")[1]);
            String pressF = String.format("%.3f", new Object[] { Double.valueOf(pre) });
            res.put("press", pressF);
          }
          if (i < bb5.size()) {
            double t = Double.parseDouble(bb5.get(i).toString().split(":")[1]);
            String topBoltPositionF = String.format("%.3f", new Object[] { Double.valueOf(t) });
            res.put("topBoltPosition", topBoltPositionF);
          }
          if (i < bb6.size()) {
            res.put("trainNo", bb6.get(i).toString().split(":")[1]);
          }
          result.add(res);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }

      return result;
    }
    public static String parseDate(LocalDateTime localDate, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDate.format(dateTimeFormatter);
      }

      public static String todayFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(calendar.getTime());
        return dateStr;
      }

      public static Date StringToDate(String dateStr) throws ParseException
      {
        Date date = new SimpleDateFormat("HH:mm:ss").parse(dateStr);
        return date;
      }
      public List<Map<String, Object>> getDictFormatter(String dictcode)
      {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.erpcode_s, t.dictname_s from AT_CM_BS_COREDICTIONARY t where t.dictcode_s like '");
        sql.append(dictcode);
        sql.append("%'   ");
        sql.append(" and t.erpcode_s is not null and t.deleted_i='0'");
        SQLQuery query = createSQLQuery(sql.toString());
        return query.list();
      }

}
