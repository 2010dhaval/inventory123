package com.untitle.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.untitle.inventory.dao.IMenuAccessDAO;
import com.untitle.inventory.dto.MenuAccessDTO;
import com.untitle.inventory.model.MenuAccess;
import com.untitle.inventory.service.IMenuAccessService;

public class MenuAccessService implements IMenuAccessService {

private IMenuAccessDAO menuAccessDAO;
	
	public void setMenuAccessDAO(IMenuAccessDAO menuAccessDAO) {
		this.menuAccessDAO = menuAccessDAO;
	}
	public IMenuAccessDAO getMenuAccessDAO() {
		return menuAccessDAO;
	}
	
	@Override
	public List<MenuAccessDTO> getMenuId(Long userTypeId) {
		// TODO Auto-generated method stub
		List<MenuAccess> menuAccessList = menuAccessDAO.getMenuAccess(userTypeId);
		List<MenuAccessDTO> menuAccessDTOList = new ArrayList<MenuAccessDTO>();
		for(MenuAccess menuAccess: menuAccessList)
		{
			MenuAccessDTO menuAccessDTO = new MenuAccessDTO();
			menuAccessDTO.setId(menuAccess.getId());
			menuAccessDTO.setUserTypeId(menuAccess.getUserTypeId());
			menuAccessDTO.setMenuId(menuAccess.getMenuId());
			menuAccessDTOList.add(menuAccessDTO);
		}
		return menuAccessDTOList;

	}

	@Override
	public void modifyAccessDetails(Long userTypeId, List accessIds) {
		// TODO Auto-generated method stub
		menuAccessDAO.modifyMenuAccessData(userTypeId, accessIds);
	}

}
