package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RFQ_ITEM_REQ")
public class RFQ_ITEM_REQ {
	
	@Id
	@GeneratedValue
	@Column(name = "RFQ_NO")
	private Long rfqNo;
	
	@Column(name = "RFQ_VERSION")
	private Long rfqVersion;
	
	@Column(name = "RFQ_ITEM")
	private Long rfqItem;
	
	@Column(name = "RFQ_REQITEM")
	private Long rfqReqItem;
	
	
	@Column(name = "PREQ_NO")
	private String preqNo;
	
	@Column(name = "PREQ_ITEM")
	private Double preqItem;	
	
	@Column(name = "MATERIAL")
	private String material;
	
	@Column(name = "MATL_GROUP")
	private String materialGroup;	
	
	@Column(name = "QUANTITY")
	private Double quantity;
	
	@Column(name = "PLANT")
	private String plant;

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

	public Long getRfqReqItem() {
		return rfqReqItem;
	}

	public void setRfqReqItem(Long rfqReqItem) {
		this.rfqReqItem = rfqReqItem;
	}

	public String getPreqNo() {
		return preqNo;
	}

	public void setPreqNo(String preqNo) {
		this.preqNo = preqNo;
	}

	public Double getPreqItem() {
		return preqItem;
	}

	public void setPreqItem(Double preqItem) {
		this.preqItem = preqItem;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}
	
	
	
	
	

}
