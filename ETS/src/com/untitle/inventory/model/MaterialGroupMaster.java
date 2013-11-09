package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="MaterialGroupMaster")
public class MaterialGroupMaster {
	@Id
	@Column(name="material_group_code")
	private String materialGroupCode;
	@Column(name="material_group_desc")
	private String materialGroupDesc;
	@Column(name="client")
	private String client;
	public String getMaterialGroupCode() {
		return materialGroupCode;
	}
	public void setMaterialGroupCode(String materialGroupCode) {
		this.materialGroupCode = materialGroupCode;
	}
	public String getMaterialGroupDesc() {
		return materialGroupDesc;
	}
	public void setMaterialGroupDesc(String materialGroupDesc) {
		this.materialGroupDesc = materialGroupDesc;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
}
