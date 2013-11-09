package com.untitle.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class MaterialGroupMasterDTO {

	private String materialGroupCode;
	private String materialGroupDesc;
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
