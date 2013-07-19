package com.untitle.inventory.service;

import com.untitle.inventory.dto.UserMasterDTO;

public interface IUserMasterService {

	UserMasterDTO authenticate(String userName,String password);
	public void  changePassword(UserMasterDTO userMasterDTO);
}
