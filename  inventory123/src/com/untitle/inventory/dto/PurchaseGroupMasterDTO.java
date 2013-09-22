package com.untitle.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class PurchaseGroupMasterDTO {

	private String purchaseGroupCode;
	private String purchaseGroupDesc;
	private String client;
	public String getPurchaseGroupCode() {
		return purchaseGroupCode;
	}
	public void setPurchaseGroupCode(String purchaseGroupCode) {
		this.purchaseGroupCode = purchaseGroupCode;
	}
	public String getPurchaseGroupDesc() {
		return purchaseGroupDesc;
	}
	public void setPurchaseGroupDesc(String purchaseGroupDesc) {
		this.purchaseGroupDesc = purchaseGroupDesc;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	

}
