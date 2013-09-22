package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="REQ_ITEM")
//@NamedQueries({
//@NamedQuery(name="getRangeDetailsById",query="from RangeMaster rm where rm.rangeCode = :rangeCode"),@NamedQuery(name="getRangeDetails",query="from RangeMaster rm")})
public class REQMaster {

	@Id
	@Column(name="reqid")
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="PREQ_NO")
	private String preqNO;
	@Column(name="PREQ_ITEM")
	private String preqItem;
	@Column(name="PUR_GROUP")
	private String purGroup;
	@Column(name="MATERIAL")
	private String material;
	@Column(name="PLANT")
	private String plant;
	@Column(name="MAT_GRP")
	private String materialGroup;
	public String getPreqNO() {
		return preqNO;
	}
	public String getPreqItem() {
		return preqItem;
	}
	public String getPurGroup() {
		return purGroup;
	}
	public String getMaterial() {
		return material;
	}
	public String getPlant() {
		return plant;
	}
	public String getMaterialGroup() {
		return materialGroup;
	}
	public void setPreqNO(String preqNO) {
		this.preqNO = preqNO;
	}
	public void setPreqItem(String preqItem) {
		this.preqItem = preqItem;
	}
	public void setPurGroup(String purGroup) {
		this.purGroup = purGroup;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}
		

}


