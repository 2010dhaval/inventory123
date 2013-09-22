package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PurchaseGroupMaster")
public class PurchaseGroupMaster {
	@Id
	@Column(name="purchase_group_code")
	private String purchaseGroupCode;
	@Column(name="purchase_group_desc")
	private String purchaseGroupDesc;
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
	@Column(name="client")
	private String client;
	
}
