package com.untitle.inventory.dto;

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

public class IngredientMasterDTO {
	private Long ingCode;
	private String ingDesc;
	private String ingRange;
	private UOMMasterDTO uomMasterDTO;
	private Double purPrice;
	private Double warQry;
	private int isDeleted;
	public Long getIngCode() {
		return ingCode;
	}
	public void setIngCode(Long ingCode) {
		this.ingCode = ingCode;
	}
	public String getIngDesc() {
		return ingDesc;
	}
	public void setIngDesc(String ingDesc) {
		this.ingDesc = ingDesc;
	}
	public String getIngRange() {
		return ingRange;
	}
	public void setIngRange(String ingRange) {
		this.ingRange = ingRange;
	}
	public UOMMasterDTO getUomMasterDTO() {
		return uomMasterDTO;
	}
	public void setUomMasterDTO(UOMMasterDTO uomMasterDTO) {
		this.uomMasterDTO = uomMasterDTO;
	}
	public Double getPurPrice() {
		return purPrice;
	}
	public void setPurPrice(Double purPrice) {
		this.purPrice = purPrice;
	}
	public Double getWarQry() {
		return warQry;
	}
	public void setWarQry(Double warQry) {
		this.warQry = warQry;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
