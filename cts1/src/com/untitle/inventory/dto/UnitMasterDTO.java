package com.untitle.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


public class UnitMasterDTO {
	private Long unitCode;
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
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	private String unitName;
	private String unitAddress;
	private String resPerName;
	private String resPerContactNo;
	private int isDeleted;
	
}
