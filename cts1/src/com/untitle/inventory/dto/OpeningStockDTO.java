package com.untitle.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.untitle.inventory.model.ItemHeader;


public class OpeningStockDTO {
	private Long voucherCode;
	private Integer type;
	private int isDeleted;
	private ItemHeaderDTO itemHeaderDTO;
	private IngredientMasterDTO ingredientMasterDTO;
	private UOMMasterDTO uomMasterDTO;
	private UOMMasterDTO uomMasterDamagedDTO;
	private String openingDate;
	private Double openingQty;
	private UnitMasterDTO unitMasterDTO;
	private Double damagedQty;
	private Double price;
	public Long getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(Long voucherCode) {
		this.voucherCode = voucherCode;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public ItemHeaderDTO getItemHeaderDTO() {
		return itemHeaderDTO;
	}
	public void setItemHeaderDTO(ItemHeaderDTO itemHeaderDTO) {
		this.itemHeaderDTO = itemHeaderDTO;
	}
	public UOMMasterDTO getUomMasterDTO() {
		return uomMasterDTO;
	}
	public void setUomMasterDTO(UOMMasterDTO uomMasterDTO) {
		this.uomMasterDTO = uomMasterDTO;
	}
	public UOMMasterDTO getUomMasterDamagedDTO() {
		return uomMasterDamagedDTO;
	}
	public void setUomMasterDamagedDTO(UOMMasterDTO uomMasterDamagedDTO) {
		this.uomMasterDamagedDTO = uomMasterDamagedDTO;
	}
	public String getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}
	public Double getOpeningQty() {
		return openingQty;
	}
	public void setOpeningQty(Double openingQty) {
		this.openingQty = openingQty;
	}
	public UnitMasterDTO getUnitMasterDTO() {
		return unitMasterDTO;
	}
	public void setUnitMasterDTO(UnitMasterDTO unitMasterDTO) {
		this.unitMasterDTO = unitMasterDTO;
	}
	public Double getDamagedQty() {
		return damagedQty;
	}
	public void setDamagedQty(Double damagedQty) {
		this.damagedQty = damagedQty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public IngredientMasterDTO getIngredientMasterDTO() {
		return ingredientMasterDTO;
	}
	public void setIngredientMasterDTO(IngredientMasterDTO ingredientMasterDTO) {
		this.ingredientMasterDTO = ingredientMasterDTO;
	}
	
	
	}
