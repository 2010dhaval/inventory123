package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="unit_master")
@NamedQueries({
@NamedQuery(name="getUnitDetailsById",query="from UnitMaster um where um.unitCode = :unitCode"),@NamedQuery(name="getUnitDetails",query="from UnitMaster um")})
public class UnitMaster {
	@Id
	@GeneratedValue
	@Column(name="um_unitCode")
	private Long unitCode;
	@Column(name="um_unitName")
	private String unitName;
	@Column(name="um_unitAddress")
	private String unitAddress;
	@Column(name="um_resPerName")
	private String resPerName;
	@Column(name="um_resPerContactNo")
	private String resPerContactNo;
	
	
	public Long getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(Long unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getResPerName() {
		return resPerName;
	}
	public void setResPerName(String resPerName) {
		this.resPerName = resPerName;
	}
	public String getResPerContactNo() {
		return resPerContactNo;
	}
	public void setResPerContactNo(String resPerContactNo) {
		this.resPerContactNo = resPerContactNo;
	}
	@Column(name="isDeleted")
	private int isDeleted;
	
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
