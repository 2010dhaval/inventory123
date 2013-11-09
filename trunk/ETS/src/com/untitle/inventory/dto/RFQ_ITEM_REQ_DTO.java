package com.untitle.inventory.dto;



public class RFQ_ITEM_REQ_DTO {	
	
	
	private Long rfqNo;
	
	
	private Long rfqVersion;
	
	
	private Long rfqItem;
	
	
	private Long rfqReqItem;	
	

	private String preqNo;
	
	
	private Double preqItem;	
	

	private String material;
	
	
	private String materialGroup;	
	
	
	private Double quantity;
	
	
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
