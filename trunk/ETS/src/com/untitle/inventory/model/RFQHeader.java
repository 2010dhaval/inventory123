package com.untitle.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RFQ_HEADER")
public class RFQHeader {
	@Id
	@GeneratedValue
	@Column(name = "RFQ_NO")
	private Long rfqNo;
	
	@Column(name = "RFQ_Version")
	private Long rfqVersion;
	
	@Column(name = "vper_start")
	private Date vperStart;
	
	@Column(name = "vper_end")
	private Date vperEnd;
	
	@Column(name = "Comp_code")
	private String compCode;
	
	@Column(name = "PUR_GROUP")
	private String purGroup;

	public Long getRfqNo() {
		return rfqNo;
	}

	public void setRfqNo(Long rfqNo) {
		this.rfqNo = rfqNo;
	}

	public Long getRfqVersion() {
		return rfqVersion;
	}

	public void setRfqVersion(Long rfqVersion) {
		this.rfqVersion = rfqVersion;
	}

	public Date getVperStart() {
		return vperStart;
	}

	public void setVperStart(Date vperStart) {
		this.vperStart = vperStart;
	}

	public Date getVperEnd() {
		return vperEnd;
	}

	public void setVperEnd(Date vperEnd) {
		this.vperEnd = vperEnd;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getPurGroup() {
		return purGroup;
	}

	public void setPurGroup(String purGroup) {
		this.purGroup = purGroup;
	}

}
