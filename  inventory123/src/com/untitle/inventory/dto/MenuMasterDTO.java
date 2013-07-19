package com.untitle.inventory.dto;

import java.io.Serializable;
import java.util.List;

public class MenuMasterDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private String url;
	private Long parentMenu;
	private List<MenuMasterDTO> childMenu;
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
	public void setChildMenu(List<MenuMasterDTO> childMenu) {
		this.childMenu = childMenu;
	}
	public List<MenuMasterDTO> getChildMenu() {
		return childMenu;
	}

}
