package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="menu_access")
@NamedQueries({
@NamedQuery(name="getMenuAccess",query="FROM MenuAccess ma WHERE ma.userTypeId = :userTypeId")})
public class MenuAccess {
	
	@Column(name="ma_id")
	@Id
	private Long id;
	@Column(name="ma_type_id")
	private Long userTypeId;
	@Column(name="ma_menu_id")
	private Long menuId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}
	
}
