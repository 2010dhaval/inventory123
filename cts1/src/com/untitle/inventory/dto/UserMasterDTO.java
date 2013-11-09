package com.untitle.inventory.dto;

import java.util.Date;

public class UserMasterDTO {
	private Long id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private UserTypeMasterDTO userTypeMasterDTO;
	public UserTypeMasterDTO getUserTypeMasterDTO() {
		return userTypeMasterDTO;
	}
	public void setUserTypeMasterDTO(UserTypeMasterDTO userTypeMasterDTO) {
		this.userTypeMasterDTO = userTypeMasterDTO;
	}
	private Integer disable;
	private Date disableOn;
	private String emailID;
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDisableOn() {
		return disableOn;
	}
	public void setDisableOn(Date disableOn) {
		this.disableOn = disableOn;
	}
	
	public void setDisable(Integer disable) {
		this.disable = disable;
	}
	public Integer getDisable() {
		return disable;
	}

}
