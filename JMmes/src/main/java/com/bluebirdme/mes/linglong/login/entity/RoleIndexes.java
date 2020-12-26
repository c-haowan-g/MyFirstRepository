package com.bluebirdme.mes.linglong.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.core.system.base.entity.BaseEntity;

/**
 * 
 * @author Goofy
 * @Date 2019年4月2日 上午11:08:17
 */
@Entity
@XmlRootElement
@Table(name = "CORE_ROLE_INDEXES")
public class RoleIndexes extends BaseEntity {
	
	@Comment("ROLEID")
	@Column(name="ROLEID")
	private Long roleId;
	@Column(name="MENUID")
	private Long menuId;
	@Column(name="MENUURL")
	private String menuUrl;
	@Column(name="MENUNAME")
	private String menuName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
