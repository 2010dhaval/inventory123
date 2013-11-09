package com.untitle.inventory.dto;

import java.io.Serializable;
import java.util.List;

public class ItemHeaderDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public RangeMasterDTO getRangeMasterDTO() {
		return rangeMasterDTO;
	}
	public void setRangeMasterDTO(RangeMasterDTO rangeMasterDTO) {
		this.rangeMasterDTO = rangeMasterDTO;
	}
	public UOMMasterDTO getUomMasterDTO() {
		return uomMasterDTO;
	}
	public void setUomMasterDTO(UOMMasterDTO uomMasterDTO) {
		this.uomMasterDTO = uomMasterDTO;
	}
	public List<ItemDetailsDTO> getItemDetailsDTOs() {
		return itemDetailsDTOs;
	}
	public void setItemDetailsDTOs(List<ItemDetailsDTO> itemDetailsDTOs) {
		this.itemDetailsDTOs = itemDetailsDTOs;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Double getWarningQty() {
		return warningQty;
	}
	public void setWarningQty(Double warningQty) {
		this.warningQty = warningQty;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	private String itemDesc;
	private RangeMasterDTO rangeMasterDTO;
	private UOMMasterDTO uomMasterDTO;
	private List<ItemDetailsDTO> itemDetailsDTOs;
	private Double sellingPrice;
	private Double warningQty;
	private Integer isDeleted;
	
}
