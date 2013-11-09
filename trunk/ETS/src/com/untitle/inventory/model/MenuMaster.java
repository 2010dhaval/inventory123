package com.untitle.inventory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu_master")
@NamedQueries({
@NamedQuery(name="getMenu",query="FROM MenuAccess ma WHERE ma.userTypeId = :userTypeId"),
@NamedQuery(name="getMenuAccessUsingUserTypeId",query="FROM MenuMaster mm WHERE mm.parentMenu =:parentMenuId AND mm.id IN (select ma.menuId FROM MenuAccess ma WHERE ma.userTypeId = :userTypeId)")})
public class MenuMaster {
	
	@Column(name="mm_id")
	@Id
	private Long id;
	@Column(name="mm_description")
	private String description;
	@Column(name="mm_url")
	private String url;
	@Column(name="mm_parent_menu")
	private Long parentMenu;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Menu_access", joinColumns = {
			@JoinColumn(name = "mm_id") }, inverseJoinColumns = { 
			@JoinColumn(name = "ma_menu_id") })
	private List<MenuMaster> childMenu;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Long parentMenu) {
		this.parentMenu = parentMenu;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setChildMenu(List<MenuMaster> childMenu) {
		this.childMenu = childMenu;
	}
	public List<MenuMaster> getChildMenu() {
		return childMenu;
	}

}
