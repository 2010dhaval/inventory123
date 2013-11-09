package com.untitle.inventory.model;

import java.util.Date;

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

import com.untitle.inventory.dto.ItemHeaderDTO;
import com.untitle.inventory.dto.UOMMasterDTO;
import com.untitle.inventory.dto.UnitMasterDTO;

@Entity
@Table(name="opening_stock_voucher")
//@NamedQueries({
//@NamedQuery(name="getIngredientDetailsById",query="from IngredientMaster im where im.ingCode = :ingCode"),@NamedQuery(name="getIngredientDetails",query="from IngredientMaster im")})
public class OpeningStock {
	@Id
	@Column(name="v_code")
	@GeneratedValue
	private Long voucherCode;
	@Column(name="v_type")
	private Integer type;
	@Column(name="isDeleted")
	private int isDeleted;
	@ManyToOne
	@JoinColumn(name="v_item_header_id",referencedColumnName="ih_id")
	private ItemHeader itemHeader;
	@ManyToOne
	@JoinColumn(name="v_ingredient_id",referencedColumnName="im_code")
	private IngredientMaster ingredientMaster;
	@ManyToOne
	@JoinColumn(name="v_uom_code",referencedColumnName="um_id")
	private UOMMaster uomMaster;
	@ManyToOne
	@JoinColumn(name="v_damaged_qty_uom",referencedColumnName="um_id")
	private UOMMaster uomMasterDamaged;
	@Column(name="v_opening_date")
	private Date openingDate;
	@Column(name="v_opening_qty")
	private Double openingQty;
	@ManyToOne
	@JoinColumn(name="v_unit_code",referencedColumnName="um_unitCode")
	private UnitMasterDTO unitMasterDTO;
	@Column(name="v_damaged_qty")
	private Double damagedQty;
	@Column(name="v_price")
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
	public ItemHeader getItemHeader() {
		return itemHeader;
	}
	public void setItemHeader(ItemHeader itemHeader) {
		this.itemHeader = itemHeader;
	}
	public IngredientMaster getIngredientMaster() {
		return ingredientMaster;
	}
	public void setIngredientMaster(IngredientMaster ingredientMaster) {
		this.ingredientMaster = ingredientMaster;
	}
	public UOMMaster getUomMaster() {
		return uomMaster;
	}
	public void setUomMaster(UOMMaster uomMaster) {
		this.uomMaster = uomMaster;
	}
	public UOMMaster getUomMasterDamaged() {
		return uomMasterDamaged;
	}
	public void setUomMasterDamaged(UOMMaster uomMasterDamaged) {
		this.uomMasterDamaged = uomMasterDamaged;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
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
	}
