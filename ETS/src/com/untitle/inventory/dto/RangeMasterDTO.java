package com.untitle.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


public class RangeMasterDTO {
	private String rangeCode;
	private String rangeDesc;
	public String getRangeCode() {
		return rangeCode;
	}
	public void setRangeCode(String rangeCode) {
		this.rangeCode = rangeCode;
	}
	public String getRangeDesc() {
		return rangeDesc;
	}
	public void setRangeDesc(String rangeDesc) {
		this.rangeDesc = rangeDesc;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	private int isDeleted;
	
	}
