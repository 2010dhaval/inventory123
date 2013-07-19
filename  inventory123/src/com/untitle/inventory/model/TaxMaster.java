package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tax_master")
@NamedQueries({
@NamedQuery(name="getTaxDetailsById",query="from TaxMaster tm where tm.taxCode = :taxCode"),@NamedQuery(name="getTaxDetails",query="from TaxMaster tm")})
public class TaxMaster {
	@Id
	@Column(name="tm_taxCode")
	private String taxCode;
	@Column(name="tm_taxDesc")
	private String taxDesc;
	@Column(name="tm_percentage")
	private Double taxPercentage;
	
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getTaxDesc() {
		return taxDesc;
	}
	public void setTaxDesc(String taxDesc) {
		this.taxDesc = taxDesc;
	}
	public Double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(Double taxPercentage) {
		this.taxPercentage = taxPercentage;
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
