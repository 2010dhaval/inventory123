package com.untitle.inventory.dao;

import com.untitle.inventory.model.UserMaster;

public interface IUserMasterDAO {
	UserMaster authenticate(String userName,String password);
	void saveUserMaster(UserMaster userMaster);
}
