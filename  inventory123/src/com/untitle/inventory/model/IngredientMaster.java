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
@Table(name="ingredient_master")
@NamedQueries({
@NamedQuery(name="getIngredientDetailsById",query="from IngredientMaster im where im.ingCode = :ingCode"),@NamedQuery(name="getIngredientDetails",query="from IngredientMaster im")})
public class IngredientMaster {
	@Id
	@Column(name="im_code")
	@GeneratedValue
	private Long ingCode;
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
	public UOMMaster getUomMaster() {
		return uomMaster;
	}
	public void setUomMaster(UOMMaster uomMaster) {
		this.uomMaster = uomMaster;
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
	@Column(name="im_desc")
	private String ingDesc;
	@Column(name="im_range")
	private String ingRange;
	@ManyToOne()
	@JoinColumn(name="im_baseuom",referencedColumnName="um_id")
	private UOMMaster uomMaster;
	@Column(name="im_purprice")
	private Double purPrice;
	@Column(name="im_warningQty")
	private Double warQry;
	@Column(name="isDeleted")
	private int isDeleted;
	
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
