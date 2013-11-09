package com.untitle.inventory.dao;

import java.util.List;

import com.untitle.inventory.model.MenuMaster;

public interface IMenuMasterDAO {
	List<MenuMaster> getMenuData(Long parentMenuId);
	List<MenuMaster> getMenuData(Long parentMenuId, Long userTypeId);

}
