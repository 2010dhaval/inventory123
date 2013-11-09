package com.untitle.inventory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.untitle.inventory.constants.*;
import com.untitle.inventory.dao.ICommonDAO;
import com.untitle.inventory.dto.MenuMasterDTO;
import com.untitle.inventory.model.MenuMaster;
import com.untitle.inventory.service.IMenuService;

@Service("IMenuService")
@Transactional
public class MenuService implements IMenuService {

	@Autowired
	ICommonDAO<MenuMaster> commonDAO;
	
	public ICommonDAO<MenuMaster> getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(ICommonDAO<MenuMaster> commonDAO) {
		this.commonDAO = commonDAO;
	}

	@Override
	public List<MenuMasterDTO> getMenuData() {
		return getChildMenus(Constants.ROOT_PARENT_MENU_ID);
	}

	// To get Child Menus
	private List<MenuMasterDTO> getChildMenus(Long parentMenuId)
	{
		Map<String,Object> properyMap=new HashMap<String,Object>();
		properyMap.put("parentMenuId", parentMenuId);
		
		List<MenuMaster> menuMasterList=commonDAO.findByNamedQuery("getMenu", properyMap);
		
		//List<MenuMaster> menuMasterList = menuMasterDAO.getMenuData(parentMenuId);
		List<MenuMasterDTO> menuMasterDTOList = new ArrayList<MenuMasterDTO>();
		for (MenuMaster menuMaster : menuMasterList)
		{
			MenuMasterDTO menuMasterDTO = new MenuMasterDTO();
			menuMasterDTO.setId(menuMaster.getId());
			menuMasterDTO.setDescription(menuMaster.getDescription());
			menuMasterDTO.setUrl(menuMaster.getUrl());
			menuMasterDTO.setParentMenu(menuMaster.getParentMenu());
			menuMasterDTO.setChildMenu(getChildMenus(menuMaster.getId()));
			menuMasterDTOList.add(menuMasterDTO);
		}
		return menuMasterDTOList;
	}


	@Override
	public List<MenuMasterDTO> getAccessMenu(Long userTypeId) {
		// TODO Auto-generated method stub
		return getChildMenus(Constants.ROOT_PARENT_MENU_ID, userTypeId);
	}

	private List<MenuMasterDTO> getChildMenus(Long ParentMenuId, Long userTypeId)
	{
		Map<String,Object> properyMap=new HashMap<String,Object>();
		properyMap.put("parentMenuId", ParentMenuId);
		properyMap.put("userTypeId", userTypeId);
		
		List<MenuMaster> menuMasterList=commonDAO.findByNamedQuery("getMenuAccessUsingUserTypeId", properyMap);
		
		
		List<MenuMasterDTO> menuMasterDTOList = new ArrayList<MenuMasterDTO>();
		for (MenuMaster menuMaster : menuMasterList)
		{
			MenuMasterDTO menuMasterDTO = new MenuMasterDTO();
			menuMasterDTO.setId(menuMaster.getId());
			menuMasterDTO.setDescription(menuMaster.getDescription());
			menuMasterDTO.setUrl(menuMaster.getUrl());
			menuMasterDTO.setParentMenu(menuMaster.getParentMenu());
			properyMap.clear();
			properyMap.put("parentMenuId", menuMaster.getId());
			properyMap.put("userTypeId", userTypeId);
			
			if (commonDAO.findByNamedQuery("getMenuAccessUsingUserTypeId", properyMap).size() != 0) {
				menuMasterDTO.setChildMenu(getChildMenus(menuMaster.getId(), userTypeId));
			}
			menuMasterDTOList.add(menuMasterDTO);
		}
		return menuMasterDTOList;
	}

}
