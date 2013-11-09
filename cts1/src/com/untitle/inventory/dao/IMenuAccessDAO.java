package com.untitle.inventory.dao;

import java.util.List;

import com.untitle.inventory.model.MenuAccess;

public interface IMenuAccessDAO {
	void saveOrUpdate (MenuAccess menuAccess);
	List<MenuAccess> getMenuAccess(Long userTypeId);
	void modifyMenuAccessData (Long userTypeId, List accessIds);

}
