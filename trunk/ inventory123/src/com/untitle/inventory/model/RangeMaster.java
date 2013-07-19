package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="range_master")
@NamedQueries({
@NamedQuery(name="getRangeDetailsById",query="from RangeMaster rm where rm.rangeCode = :rangeCode"),@NamedQuery(name="getRangeDetails",query="from RangeMaster rm")})
public class RangeMaster {
	@Id
	@Column(name="rm_rangeCode")
	private String rangeCode;
	@Column(name="rm_rangeDesc")
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
	@Column(name="isDeleted")
	private int isDeleted;
	
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
