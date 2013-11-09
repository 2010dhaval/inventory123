package com.untitle.inventory.dto;

import java.io.Serializable;
import java.util.List;

public class ItemDetailsDTO implements Serializable{
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
	public ItemHeaderDTO getItemHeaderDTO() {
		return itemHeaderDTO;
	}
	public void setItemHeaderDTO(ItemHeaderDTO itemHeaderDTO) {
		this.itemHeaderDTO = itemHeaderDTO;
	}
	public IngredientMasterDTO getIngredientMasterDTO() {
		return ingredientMasterDTO;
	}
	public void setIngredientMasterDTO(IngredientMasterDTO ingredientMasterDTO) {
		this.ingredientMasterDTO = ingredientMasterDTO;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getWastagePer() {
		return wastagePer;
	}
	public void setWastagePer(Double wastagePer) {
		this.wastagePer = wastagePer;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	private ItemHeaderDTO itemHeaderDTO;
	private IngredientMasterDTO ingredientMasterDTO;
	private Double quantity;
	private Double wastagePer;
	private Integer isDeleted;
	
}
