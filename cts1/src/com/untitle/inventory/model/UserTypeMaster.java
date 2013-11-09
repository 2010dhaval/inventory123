package com.untitle.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type_master")
public class UserTypeMaster {
	@Column(name="utm_id")
	@Id
private Long id;
	@Column(name="utm_type")	
private String userType;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
}
