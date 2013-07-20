package com.untitle.inventory.model;

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

@Entity
@Table(name="item_details")
//@NamedQueries({
//@NamedQuery(name="getIngredientDetailsById",query="from IngredientMaster im where im.ingCode = :ingCode"),@NamedQuery(name="getIngredientDetails",query="from IngredientMaster im")})
public class ItemDetails {
		@Column(name="isDeleted")
	private int isDeleted;
	
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
