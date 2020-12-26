package com.bluebirdme.mes.linglong.mix.service;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.MixCarReport;
//import com.bluebirdme.mes.linglong.mix.entity.dto.MixCarReportDTO;
import com.lhqx.ArrayOfanyType;
import com.lhqx.PIReturnObject;
import com.lhqx.WSImplement;
import com.lhqx.WSInterface;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

@Service
@Transactional(rollbackFor={Exception.class})
public class MixCarReportServiceImpl extends RockWellBaseServiceImpl<MixCarReport>
{

  @Resource
  LingLongDataSource llds;

  protected Session getSession()
  {
    return this.llds.getSession();
  }

  protected Class getEntity()
  {
    return MixCarReport.class;
  }

  protected boolean useCache()
  {
    return false;
  }

 /* @RockWellTransactional
  public void saveChanges(MixCarReportDTO mixcarreport) throws Exception
  {
    if (!ListUtils.isEmpty(mixcarreport.getDeleted())) {
      delete(mixcarreport.getDeleted());
    }
    if (!ListUtils.isEmpty(mixcarreport.getInserted())) {
      save(mixcarreport.getInserted());
    }
    if (!ListUtils.isEmpty(mixcarreport.getUpdated()))
      update(mixcarreport.getUpdated());
  }
*/
  public List<Map<String, Object>> ljqx(Map<String, Object> map)
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

    LocalDateTime firstDateTime = localDateTime.minusSeconds(60L);

    start_datetime_s = parseDate(firstDateTime, "yyyy-MM-dd HH:mm:ss");
    start_datetime_s = start_datetime_s.replace("-", "");
    start_datetime_s = start_datetime_s.toString().replace(" ", "");
    start_datetime_s = start_datetime_s.toString().replace(":", "");

    LocalDateTime lastDateTime = localDateTime.plusSeconds(mixtime_l.longValue() + 120L);
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
    int it = 0;
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

    ArrayOfanyType arry6 = trainNoValue.getRPidata();
    List bb6 = arry6.getAnyType();

    ArrayOfanyType arry7 = planNoValue.getRPidata();
    List bb7 = arry7.getAnyType();

    Integer[] numbers = { Integer.valueOf(bb.size()), Integer.valueOf(bb1.size()), Integer.valueOf(bb2.size()), Integer.valueOf(bb3.size()), Integer.valueOf(bb4.size()), Integer.valueOf(bb5.size()) };
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
          Integer serial_id_s = Integer.valueOf(serial_id_i);
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
        if (i < bb1.size())
        {
          double e = Double.parseDouble(bb1.get(i).toString().split(":")[1]);

          String energyF = String.format("%.3f", new Object[] { Double.valueOf(e) });
          res.put("energy", energyF);
        }
        if (i < bb2.size())
        {
          double p = Double.parseDouble(bb2.get(i).toString().split(":")[1]);

          String powerF = String.format("%.3f", new Object[] { Double.valueOf(p) });
          res.put("power", powerF);
        }
        if (i < bb3.size())
        {
          double rot = Double.valueOf(bb3.get(i).toString().split(":")[1]).doubleValue();

          String rotF = String.format("%.3f", new Object[] { Double.valueOf(rot) });
          res.put("rotate", rotF);
        }
        if (i < bb4.size())
        {
          double pre = Double.parseDouble(bb4.get(i).toString().split(":")[1]);

          res.put("press", Double.valueOf(pre));
        }
        if (i < bb5.size())
        {
          double t = Double.parseDouble(bb5.get(i).toString().split(":")[1]);

          String topBoltPositionF = String.format("%.3f", new Object[] { Double.valueOf(t) });
          res.put("topBoltPosition", topBoltPositionF);
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

  public static Date StringToDate(String dateStr) throws ParseException {
    Date date = new SimpleDateFormat("HH:mm:ss").parse(dateStr);
    return date;
  }

  public List<Map<String, Object>> getrecipecodebycodelist(String begindate, String enddate, String equipcode)
    throws Exception
  {
    String factory = LLWebUtils.factory();
    SQLQuery query = createSQLQuery(getSQL("getrecipecodebycodelist"));
    query.setParameter("begindate", begindate);
    query.setParameter("enddate", enddate);
    query.setParameter("equipcode", equipcode);
    query.setParameter("factory", factory);
    return query.list();
  }

  public Map<String, Object> findByBarcode(Filter filter, Page page, Class clazz)
    throws Exception
  {
    Map ret = new HashMap();
    ret.put("rows", datagridRows(filter, page, clazz));
    filter.setOrder(null);
    filter.setSort(null);
    ret.put("total", datagridTotal(filter, page));
    return ret;
  }
}