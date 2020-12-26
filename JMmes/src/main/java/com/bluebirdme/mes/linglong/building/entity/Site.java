/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;


/**
 * 全钢半钢类
 * @author 刘程明
 *
 */
public class Site  {
    private String site_key;//area的id
    private String description;//描述全钢半钢
    private String iconCls;//图标
    private String state;//tree用到，默认close
	public String getSite_key() {
		return site_key;
	}
	public void setSite_key(String site_key) {
		this.site_key = site_key;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
   
  
}
