package com.untitle.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RFQ_ITEM")
public class RFQ_ITEMDTO {	
	
	private Long rfqNo;
	
	private Long rfqVersion;
	
	private Long rfqItem;
	
	private Double quantity;
	
	private String material;
	
	private String materialGroup;

	public Long getRfqNo() {
		return rfqNo;
	}

	public void setRfqNo(Long rfqNo) {
		this.rfqNo = rfqNo;
	}

	public Long getRfqVersion() {
		return rfqVersion;
	}

	public void setRfqVersion(Long rfqVersion) {
		this.rfqVersion = rfqVersion;
	}

	public Long getRfqItem() {
		return rfqItem;
	}

	public void setRfqItem(Long rfqItem) {
		this.rfqItem = rfqItem;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMaterialGroup() {
		return materialGroup;
	}

	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}
	
	
	

}
