package com.untitle.inventory.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="user_master")
@NamedQueries({
@NamedQuery(name="getUserDetails",query="from UserMaster um where um.userName = :username AND um.password = :password")})
public class UserMaster {
	@Column(name="um_id")
	@Id
	private Long id;
	@Column(name="um_username")
	private String userName;
	@Column(name="um_password")
	private String password;
	@Column(name="um_firstname")
	private String firstName;
	@Column(name="um_lastname")
	private String lastName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="um_type",referencedColumnName="utm_id")
	private UserTypeMaster userTypeMaster;
	public UserTypeMaster getUserTypeMaster() {
		return userTypeMaster;
	}
	public void setUserTypeMaster(UserTypeMaster userTypeMaster) {
		this.userTypeMaster = userTypeMaster;
	}
	@Column(name="um_disable")
	private Integer disable;
	@Column(name="um_disable_on_date")
	private Date disableOn;
	@Column(name="um_email_id")
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
