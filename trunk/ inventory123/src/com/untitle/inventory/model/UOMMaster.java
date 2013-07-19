package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="uom_master")
@NamedQueries({
@NamedQuery(name="getUOMDetailsById",query="from UOMMaster um where um.id = :uomCode"),@NamedQuery(name="getUOMDetails",query="from UOMMaster um")})
public class UOMMaster {
	@Id
	@Column(name="um_id")
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="um_uomname")
	private String uomName;
	@Column(name="isDeleted")
	private int isDeleted;
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getUomName() {
		return uomName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
}
