package com.bluebirdme.mes.linglong.mix.export;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import java.text.SimpleDateFormat;

public class BatchReportExportHandler extends DefaultExcelExportHandler
{
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public void regFormatter()
  {
    regFormatter("addcbtime_i", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("addnrtime_i", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("addoiltime_i", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("agenc_no_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("allche_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("arch_flag_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("carrier_code_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("created_by_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("created_name_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("created_time_t", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("datasource_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("dischargeenergy_f", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("dischargepower_f", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("dischargetemp_f", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("equip_code_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("equip_name_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("group_code_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("id_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("intervals_i", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("jpw_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("lot_no_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("material_code_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("material_name_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("mixtime_i", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("polyprod_id_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("product_time_t", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("prod_type_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("receive_time_t", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("recipetime_i", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("recipe_bom_version_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("recipe_code_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("record_flag_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("serial_id_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("shift_code_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("spare1_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("spare2_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("spare3_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("spare4_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("spare5_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("start_datetime_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("state_code_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("s_factory_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("weight_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
    regFormatter("wo_no_s", new IExcelValueFormatter()
    {
      public String format(Object value)
      {
        return null;
      }
    });
  }
}