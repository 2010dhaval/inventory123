package com.untitle.inventory.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class REQDTO {
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private String preqNO;
	private String preqItem;
	private String purGroup;
	private String material;
	private String plant;
	private String materialGroup;
	
	private Date delivDate;
	private String quantity;
	
	
	public Date getDelivDate() {
		return delivDate;
	}
	public void setDelivDate(Date delivDate) {
		this.delivDate = delivDate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPreqNPO() {
		return preqNO;
	}
	public String getPreqItem() {
		return preqItem;
	}
	public String getPurGroup() {
		return purGroup;
	}
	public String getMaterial() {
		return material;
	}
	public String getPlant() {
		return plant;
	}
	public String getMaterialGroup() {
		return materialGroup;
	}
	public void setPreqNPO(String preqNPO) {
		this.preqNO = preqNPO;
	}
	public void setPreqItem(String preqItem) {
		this.preqItem = preqItem;
	}
	public void setPurGroup(String purGroup) {
		this.purGroup = purGroup;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}
	


}
