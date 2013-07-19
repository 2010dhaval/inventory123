package com.untitle.inventory.service;

import java.util.List;

import com.untitle.inventory.dto.MenuMasterDTO;

public interface IMenuService {
	List<MenuMasterDTO> getMenuData();
	List<MenuMasterDTO> getAccessMenu(Long userTypeId);

}
