package com.untitle.inventory.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="RoleMenu")
public class RoleMenu {
	@Id
	@Column(name="rm_id")
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="rm_other")
	private String other;
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="rm_role_id",referencedColumnName="r_id")
	private RoleMaster roleMaster;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="rm_menu_id",referencedColumnName="m_id")
	private MenuMast menuMast;
	public RoleMaster getRoleMaster() {
		return roleMaster;
	}
	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}
	public MenuMast getMenuMast() {
		return menuMast;
	}
	public void setMenuMast(MenuMast menuMast) {
		this.menuMast = menuMast;
	}
}
