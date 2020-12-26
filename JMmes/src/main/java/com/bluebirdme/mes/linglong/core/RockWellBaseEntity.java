/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * RockWellEntity
 * @author Goofy
 * @Date 2018年6月27日 上午9:54:43
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class RockWellBaseEntity implements Serializable{
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ATR_KEY")
	public Long atr_key;
	@Id
	@Column(name = "SITE_NUM")
	private Long site_num=1L;
	private String atr_name=UUID.randomUUID().toString();
	private Long purge_status;
	private Date creation_time;
	private Date creation_time_u;
	private String creation_time_z;
	private Date last_modified_time;
	private Date last_modified_time_u;
	private String last_modified_time_z;
	private Long xfr_insert_pid;
	private Long xfr_update_pid;
	private String trx_id=UUID.randomUUID().toString();
	private Long parent_key;
	
	public Long getAtr_key() {
		return atr_key;
	}
	public void setAtr_key(Long atr_key) {
		this.atr_key = atr_key;
	}
	public Long getSite_num() {
		return site_num;
	}
	public void setSite_num(Long site_num) {
		this.site_num = site_num;
	}
	public String getAtr_name() {
		return atr_name;
	}
	public void setAtr_name(String atr_name) {
		this.atr_name = atr_name;
	}
	public Long getPurge_status() {
		return purge_status;
	}
	public void setPurge_status(Long purge_status) {
		this.purge_status = purge_status;
	}
	public Date getCreation_time() {
		return creation_time;
	}
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	public Date getCreation_time_u() {
		return creation_time_u;
	}
	public void setCreation_time_u(Date creation_time_u) {
		this.creation_time_u = creation_time_u;
	}
	public String getCreation_time_z() {
		return creation_time_z;
	}
	public void setCreation_time_z(String creation_time_z) {
		this.creation_time_z = creation_time_z;
	}
	public Date getLast_modified_time() {
		return last_modified_time;
	}
	public void setLast_modified_time(Date last_modified_time) {
		this.last_modified_time = last_modified_time;
	}
	public Date getLast_modified_time_u() {
		return last_modified_time_u;
	}
	public void setLast_modified_time_u(Date last_modified_time_u) {
		this.last_modified_time_u = last_modified_time_u;
	}
	public String getLast_modified_time_z() {
		return last_modified_time_z;
	}
	public void setLast_modified_time_z(String last_modified_time_z) {
		this.last_modified_time_z = last_modified_time_z;
	}
	public Long getXfr_insert_pid() {
		return xfr_insert_pid;
	}
	public void setXfr_insert_pid(Long xfr_insert_pid) {
		this.xfr_insert_pid = xfr_insert_pid;
	}
	public Long getXfr_update_pid() {
		return xfr_update_pid;
	}
	public void setXfr_update_pid(Long xfr_update_pid) {
		this.xfr_update_pid = xfr_update_pid;
	}
	public String getTrx_id() {
		return trx_id;
	}
	public void setTrx_id(String trx_id) {
		this.trx_id = trx_id;
	}
	public Long getParent_key() {
		return parent_key;
	}
	public void setParent_key(Long parent_key) {
		this.parent_key = parent_key;
	}

}
